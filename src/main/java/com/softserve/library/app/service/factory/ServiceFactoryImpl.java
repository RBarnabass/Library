package com.softserve.library.app.service.factory;

import com.softserve.library.app.enums.tables.Tables;
import com.softserve.library.app.service.interfaces.*;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class ServiceFactoryImpl implements ServiceFactory {

    private ServiceManager serviceManager = new ServiceContainer();
    private static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() { }

    public static ServiceFactory getFactory() {

        if (serviceFactory == null) {
            init();
        }

        return serviceFactory;
    }
    private static void init() {

        serviceFactory = new ServiceFactoryImpl();
    }

    @Override public AuthorService getAuthorService() {

        return (AuthorService) serviceManager.getService(Tables.AUTHOR);
    }
    @Override public BookService getBookService() {

        return (BookService) serviceManager.getService(Tables.BOOK);
    }
    @Override public PublisherService getPublisherService() {

        return (PublisherService) serviceManager.getService(Tables.PUBLISHER);
    }
    @Override public UserService getUserService() {

        return (UserService) serviceManager.getService(Tables.USER);
    }
    @Override public CredentialService getCredentialService() {

        return (CredentialService) serviceManager.getService(Tables.CREDENTIAL);
    }
}
