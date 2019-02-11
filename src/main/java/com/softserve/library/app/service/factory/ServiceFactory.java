package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.interfaces.AuthorService;
import com.softserve.library.app.service.interfaces.BookService;
import com.softserve.library.app.service.interfaces.PublisherService;
import com.softserve.library.app.service.interfaces.UserService;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface ServiceFactory {

    AuthorService getAuthorService();
    BookService getBookService();
    PublisherService getPublisherService();
    UserService getUserService();
}
