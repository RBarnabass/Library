package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.interfaces.*;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class ServiceFactoryImpl implements ServiceFactory {

    private final ServiceManager serviceManager = new ServiceContainer();

    // todo: change literals to enum !
    @Override public AuthorService getAuthorService() {

        return (AuthorService) serviceManager.getService("author");
    }
    @Override public BookService getBookService() {

        return (BookService) serviceManager.getService("book");
    }
    @Override public PublisherService getPublisherService() {

        return (PublisherService) serviceManager.getService("publisher");
    }
    @Override public UserService getUserService() {

        return (UserService) serviceManager.getService("user");
    }
    @Override public CredentialService getCredentialService() {

        return (CredentialService) serviceManager.getService("credential");
    }

}
