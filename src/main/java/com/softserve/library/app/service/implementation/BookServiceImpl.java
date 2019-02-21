package com.softserve.library.app.service.implementation;

import com.softserve.library.app.dao.implementation.*;
import com.softserve.library.app.dao.interfaces.*;
import com.softserve.library.app.dto.BookParametersDto;
import com.softserve.library.app.model.Book;
import com.softserve.library.app.model.BookAuthors;
import com.softserve.library.app.model.Copy;
import com.softserve.library.app.dao.implementation.BookDaoImpl;
import com.softserve.library.app.dao.interfaces.BookDao;
import com.softserve.library.app.dto.BookDto;
import com.softserve.library.app.service.interfaces.BookService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Berezhnov
 */
public class BookServiceImpl implements BookService {

    private final BookDao bookDao = new BookDaoImpl();
    private final PublisherDao publisherDao = new PublisherDaoImpl();
    private final AuthorDao authorDao = new AuthorDaoImpl();
    private final BookAuthorsDao bookAuthorsDao = new BookAuthorsDaoImpl();
    private final CopyDao copyDao = new CopyDaoImpl();

    @Override
    public boolean delete(int id) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override
    public boolean update(Book book) throws SQLException {

        //todo: implement me !
        return false;
    }

    @Override
    public Book get(int id) throws SQLException {

        return bookDao.get(id);
    }

    @Override public boolean add(Book book) throws SQLException {

        if (book.getName() == null || book.getPublisher().getName() == null || book.getPublishYear() <= 0) {
            return false;
        }

        if (book.getName().isEmpty() || book.getPublisher().getName().isEmpty()) {
            return false;
        }

        for (int i = 0; i < book.getAuthors().size(); i++) {

            if (book.getAuthors().get(i).getName() == null || book.getAuthors().get(i).getName().isEmpty()) {
                return false;
            }
        }

        int id = 0;

        if (publisherDao.getByName(book.getPublisher().getName()) == null) {

            id = publisherDao.addAndGetIdBack(book.getPublisher());

            if (id <=0) {
                return false;
            } else {
                book.getPublisher().setId(id);
            }
        }

        String authorName;

        for (int i = 0; i < book.getAuthors().size(); i++) {

            authorName = book.getAuthors().get(i).getName();

            if (authorDao.getByName(authorName) == null) {

                id = authorDao.addAndGetIdBack(book.getAuthors().get(i));

                if (id <= 0) {
                    return false;
                } else {
                    book.getAuthors().get(i).setId(id);
                }
            }
        }

        List<Book> bookList;

        if ((bookList = bookDao.getAllByBookNameAndPublisherAndAuthor(book.getName(), book.getPublisher().getName(), book.getAuthors().get(0).getName())) == null
                || bookList.isEmpty()) {

            id = bookDao.addBookAndGetIdBack(book);

            if (id <= 0) {
                return false;
            }

            BookAuthors bookAuthors = new BookAuthors();
            for (int i = 0; i < book.getAuthors().size(); i++) {

                bookAuthors.setBookId(id);
                bookAuthors.setAuthorId(book.getAuthors().get(i).getId());
                bookAuthors.setPrimary(book.getAuthors().get(i).isPrimary());

                if (!bookAuthorsDao.add(bookAuthors)) {
                    return false;
                }

                Copy copy = new Copy();
                copy.setBookId(id);
            }

        } else {

            int dd = bookList.get(0).getId();
            Copy copy = new Copy();
            copy.setBookId(dd);
            copyDao.add(copy);
        }

        return true;
    }

    @Override
    public List<BookDto> getAllByParameters(BookParametersDto bookParametersDto) throws SQLException {


        List<Book> books;
        List<BookDto> bookDtos = new ArrayList<>();

        if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllBooks();

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByPublisher(bookParametersDto.getPublisher());

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByPublishYearPeriod(bookParametersDto.getYearPublishedFrom(),
                    bookParametersDto.getYearPublishedTo());

        } else if (bookParametersDto.getName() == null && bookParametersDto.getAuthor() != null
                && bookParametersDto.getPublisher() == null && (bookParametersDto.getYearPublishedFrom() == 0 &&
                bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByAuthor(bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByBookName(bookParametersDto.getName());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByBookNameAndPublisher(bookParametersDto.getName(), bookParametersDto.getPublisher());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByBookNameAndYearPeriod(bookParametersDto.getName(),
                    bookParametersDto.getYearPublishedFrom(), bookParametersDto.getYearPublishedTo());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByBookNameAndAuthor(bookParametersDto.getName(), bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByBookNameAndPublisherAndYearPeriod(bookParametersDto.getName(),
                    bookParametersDto.getPublisher(), bookParametersDto.getYearPublishedFrom(),
                    bookParametersDto.getYearPublishedTo());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByBookNameAndPublisherAndAuthor(bookParametersDto.getName(),
                    bookParametersDto.getPublisher(), bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByBookNameAndYearPeriodAndAuthor(bookParametersDto.getName(),
                    bookParametersDto.getYearPublishedFrom(), bookParametersDto.getYearPublishedTo(),
                    bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() != null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByBookNameAndPublisherAndYearPeriodAndAuthor(bookParametersDto.getName(),
                    bookParametersDto.getPublisher(), bookParametersDto.getYearPublishedFrom(),
                    bookParametersDto.getYearPublishedTo(), bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByPublisherAndYearPeriod(bookParametersDto.getPublisher(),
                    bookParametersDto.getYearPublishedFrom(), bookParametersDto.getYearPublishedTo());

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() == 0 && bookParametersDto.getYearPublishedTo() == 0)) {

            books = bookDao.getAllByPublisherAndAuthor(bookParametersDto.getPublisher(), bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() != null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByPublisherAndYearPeriodAndAuthor(bookParametersDto.getPublisher(),
                    bookParametersDto.getYearPublishedFrom(), bookParametersDto.getYearPublishedTo(),
                    bookParametersDto.getAuthor());

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() == null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByYearPeriod(bookParametersDto.getYearPublishedFrom(),
                    bookParametersDto.getYearPublishedTo());

        } else if (bookParametersDto.getName() == null &&
                bookParametersDto.getAuthor() != null && bookParametersDto.getPublisher() == null &&
                (bookParametersDto.getYearPublishedFrom() != 0 && bookParametersDto.getYearPublishedTo() != 0)) {

            books = bookDao.getAllByYearPeriodAndAuthor(bookParametersDto.getYearPublishedFrom(),
                    bookParametersDto.getYearPublishedTo(), bookParametersDto.getAuthor());

        } else {

            books = new ArrayList<>();
        }

        for (Book book : books) {

            BookDto bookDto = new BookDto();
            bookDto.setName(book.getName());
            bookDto.setFirstAuthorName(book.getAuthors().get(0).getName());
            bookDto.setPublisherName(book.getPublisher().getName());
            bookDto.setPublishYear(book.getPublishYear());
            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

    @Override public List<BookDto> getAll() throws SQLException {

        List<Book> books = bookDao.getAllBooks();
        List<BookDto> bookDtos = new ArrayList<>();

        for (Book book : books) {

            BookDto bookDto = new BookDto();
            bookDto.bookEntityToDto(book);
            bookDtos.add(bookDto);
        }

        return bookDtos;
    }

//    @Override public int getAllAvailableByBookId(int id) throws SQLException {
//
//        return bookDao.getAllAvailableByBookId(id);
//    }
//    @Override public List<BookDto> getAllByAuthor(String authorName) throws SQLException {
//
//        return bookDao.getAllBooksByAuthor(authorName);
//    }
//    @Override public int getBookQuantityPublishedFromYear(int year) throws SQLException {
//
//        return bookDao.getBookQuantityPublishedFromYear(year);
//    }
//
//    @Override
//    public int getNumberOfOverallBookUsages(int bookId) throws SQLException {
//
//        return bookDao.getNumberOfOverallBookUsages(bookId);
//    }
//
//    @Override
//    public int getNumberOfBookUsagesByCopy(int copyId) throws SQLException {
//
//        return bookDao.getNumberOfBookUsagesByCopy(copyId);
//    }
//
//    @Override
//    public int getAverageReadingTime(int bookId) throws SQLException {
//
//        return bookDao.getAverageReadingTime(bookId);
//    }
//
//    @Override
//    public List<CopyDto> getAllCopiesByBookName(String bookName) throws SQLException {
//        return bookDao.getAllCopiesByBookName(bookName);
//    }

//    @Override
//    public int getMostPopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException {
//        return 0;
//    }
//
//    @Override
//    public int getMostUnopularBookWithinPeriod(Date periodStartDate, Date periodEndDate) throws SQLException {
//        return 0;
//    }
}
