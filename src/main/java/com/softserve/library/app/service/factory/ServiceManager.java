package com.softserve.library.app.service.factory;

import com.softserve.library.app.service.interfaces.SimpleCrudService;

public interface ServiceManager {

    SimpleCrudService getService(String name);
}
