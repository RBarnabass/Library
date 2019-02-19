package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.interfaces.*;

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
