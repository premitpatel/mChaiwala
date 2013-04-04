/* ServiceLocator.java
 * Created By: PPATEL
 * Created On: Jan 30, 2013
 *
 * Last Revision:
 * $Revision$
 * $Date$
 * $Author$
 *
 * Copyright (c) 2013 PSCU Financial Services, Inc.
 * 560 Carillon Parkway, Saint Petersburg, Florida, 33716, U.S.A.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of PSCU
 * Financial Services, Inc.
 */

/**
 * 
 */
package com.pscu.mchaiwala.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.log4j.Logger;

/**
 * @author PPATEL
 */
public class ServiceLocator {

    private InitialContext        ctx;
    private final static Logger   logger      = Logger.getLogger(ServiceLocator.class.getName());
    private static final String   APPLICATION = "MChaiwala";
    private static final String   SEPERATOR   = "/";
    private static final String   REMOTE      = "remote";
    private static final String   LOCAL       = "local";

    /**
     * The cache to store the reference to the queue or connection factory.
     */
    private Map<Object, Object>   cache;

    // Store the single reference.
    private static ServiceLocator me;

    /**
     * Create the class at deployment
     */
    static {
        try {
            me = new ServiceLocator();
        } catch (final Exception se) {
            logger.error("Unable to create an instance of ServiceLocator Cause:" + se.getMessage(),
                         se);
        }
    }

    /**
     * Make the constructor private so that no one can accidently create another
     * ServiceLocator. Initialize te context.
     */
    private ServiceLocator() {
        try {
            ctx = new InitialContext();
        } catch (final NamingException ne) {
            ctx = null;
            logger.info("Could not get Context so, null is assigned");
            logger.error(ne);

        }
        cache = Collections.synchronizedMap(new HashMap<Object, Object>());

    }

    /**
     * This method should be called if a instance to the service locator is
     * needed.
     * 
     * @return the instance to teh service locator.
     */
    static public ServiceLocator getInstance() {
        return me;
    }

    /**
     * This method is used to lookup EJBs
     * 
     * @param beanName
     *            name of the EJB to lookup
     * @param remote
     *            indicates to lookup either remote or local EJB
     * @return
     * @throws NamingException
     */
    public Object lookupBean(String beanName, boolean remote) throws NamingException {
        Object beanObject = null;
        final String jndiName = new StringBuilder().append(APPLICATION).append(SEPERATOR).append(beanName).append(SEPERATOR).append((remote) ? REMOTE : LOCAL)
                        .toString();
        if (cache.containsKey(jndiName)) {
            beanObject = cache.get(jndiName);
        } else {
            beanObject = ctx.lookup(jndiName);
            cache.put(jndiName,
                      beanObject);
        }
        return beanObject;
    }
}
