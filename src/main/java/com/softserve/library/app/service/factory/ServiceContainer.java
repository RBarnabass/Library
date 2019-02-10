package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.implementation.AuthorServiceImpl;
import com.softserve.library.app.service.implementation.BookServiceImpl;
import com.softserve.library.app.service.implementation.PublisherServiceImpl;
import com.softserve.library.app.service.interfaces.SimpleCrudService;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Roman Berezhnov
 */
public class ServiceContainer implements ServiceManager {

    private final Map<String, SimpleCrudService> map = new HashMap<>();
    private SimpleCrudService service;

    @Override
    public SimpleCrudService getService(String name) {

        if (map.containsKey(name)) {
            service = map.get(name);
        } else {
            service = getInstance(name);
        }

        return service;
    }

    private SimpleCrudService getInstance(String name) {

        switch (name) {

            case "author": {
                service = new AuthorServiceImpl();
                break;
            }
            case "book": {
                service = new BookServiceImpl();
                break;
            }
            case "publisher": {
                service = new PublisherServiceImpl();
                break;
            }
        }
        return service;
    }
}
