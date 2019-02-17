package com.softserve.library.app.service.factory;

import com.softserve.library.app.enums.tables.Tables;
import com.softserve.library.app.service.implementation.*;
import com.softserve.library.app.service.interfaces.SimpleCrudService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class ServiceContainer implements ServiceManager {

    private final Map<Tables, SimpleCrudService> map = new HashMap<>();
    private SimpleCrudService service;

    @Override public SimpleCrudService getService(Tables name) {

        if (map.containsKey(name)) {
            service = map.get(name);
        } else {
            service = getInstance(name);
        }

        return service;
    }
    private SimpleCrudService getInstance(Tables name) {

        switch (name) {

            case AUTHOR: {
                service = new AuthorServiceImpl();
                break;
            }
            case BOOK: {
                service = new BookServiceImpl();
                break;
            }
            case PUBLISHER: {
                service = new PublisherServiceImpl();
                break;
            }
            case USER: {
                service = new UserServiceImpl();
                break;
            }
            case CREDENTIAL: {
                service = new CredentialServiceImpl();
                break;
            }
        }
        return service;
    }
}
