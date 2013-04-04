/* ChaiService.java
 * Created By: PPATEL
 * Created On: Feb 26, 2013
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
package com.pscu.mchaiwala.service.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.ext.Provider;

import com.pscu.mchaiwala.model.ChaiPayment;
import com.pscu.mchaiwala.model.Vendor;
import com.pscu.mchaiwala.service.ejb.IChaiBean;
import com.pscu.mchaiwala.service.ejb.IVendorBean;
import com.pscu.mchaiwala.util.ServiceLocator;

/**
 * @author PPATEL
 */
@Provider
@Path("/chaiservice")
public class ChaiService {

    @POST
    @Path("/chaipayment")
    @Consumes("application/json")
    @Produces("application/json")
    public String makeChaiPayment(@QueryParam("username") String username, @QueryParam("amount") Double amount, @QueryParam("vendorid") Integer vendorId) {
        IChaiBean chaiBean = null;
        String confNum = null;
        try {
            chaiBean = (IChaiBean) ServiceLocator.getInstance().lookupBean("ChaiBean",
                                                                           false);
            confNum = chaiBean.makeChaiPayment(username,
                                               amount,
                                               vendorId);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return confNum;
    }

    @GET
    @Path("/chaipayments/{username}")
    @Produces("application/json")
    public List<ChaiPayment> getChaiPayments(@PathParam("username") String username) {
        IChaiBean chaiBean = null;
        List<ChaiPayment> cPayments = null;
        try {
            chaiBean = (IChaiBean) ServiceLocator.getInstance().lookupBean("ChaiBean",
                                                                           false);
            cPayments = chaiBean.getChaiPayments(username);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return cPayments;
    }

    @GET
    @Path("/chaipayments")
    @Produces("application/json")
    public List<ChaiPayment> getChaiPayments() {
        IChaiBean chaiBean = null;
        List<ChaiPayment> cPayments = null;
        try {
            chaiBean = (IChaiBean) ServiceLocator.getInstance().lookupBean("ChaiBean",
                                                                           false);
            cPayments = chaiBean.getChaiPayments(null);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return cPayments;
    }

    @GET
    @Path("/vendors")
    @Produces("application/json")
    public List<Vendor> getVendors() {
        IVendorBean vendorBean = null;
        List<Vendor> vendors = null;
        try {
            vendorBean = (IVendorBean) ServiceLocator.getInstance().lookupBean("VendorBean",
                                                                               false);
            vendors = vendorBean.getAllVendors();
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return vendors;
    }

    @GET
    @Path("/vendors/{vendorid}")
    @Produces("application/json")
    public Vendor getVendorById(@PathParam("vendorid") Integer vendorid) {
        IVendorBean vendorBean = null;
        Vendor vendor = null;
        try {
            vendorBean = (IVendorBean) ServiceLocator.getInstance().lookupBean("VendorBean",
                                                                               false);
            vendor = vendorBean.getVendorByID(vendorid);
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return vendor;
    }
}
