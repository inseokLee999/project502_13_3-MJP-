package org.choongang.global;

import org.choongang.global.constants.Menu;

import java.security.Provider;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractServiceLocator implements ServiceLocator {
    protected static ServiceLocator instance;

    protected Map<Menu, Provider.Service> services;

    protected AbstractServiceLocator() {services = new HashMap<>(); }
}
