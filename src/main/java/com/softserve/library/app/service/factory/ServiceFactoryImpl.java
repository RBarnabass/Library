package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.interfaces.AuthorService;
import com.softserve.library.app.service.interfaces.BookService;
import com.softserve.library.app.service.interfaces.PublisherService;

public class ServiceFactoryImpl implements ServiceFactory {

    private final ServiceManager serviceManager = new ServiceContainer();

    @Override
    public AuthorService getAuthorService() {

        return (AuthorService) serviceManager.getService("author");
    }

    @Override
    public BookService getBookService() {

        return (BookService) serviceManager.getService("book");
    }

    @Override
    public PublisherService getPublisherService() {

        return (PublisherService) serviceManager.getService("publisher");
    }
}
