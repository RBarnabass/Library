package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.interfaces.SimpleCrudService;

/**
 *
 *
 * @author Roman Berezhnov
 */
public interface ServiceManager {

    SimpleCrudService getService(String name);
}
