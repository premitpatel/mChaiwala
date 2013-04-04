/* Vendor.java
 * Created By: PPATEL
 * Created On: Feb 27, 2013
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
package com.pscu.mchaiwala.model;

/**
 * @author PPATEL
 */
public class Vendor {
    private Integer vendorId;
    private String  vendorName;

    /**
     * @return the vendorId
     */
    public Integer getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId
     *            the vendorId to set
     */
    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the vendorName
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * @param vendorName
     *            the vendorName to set
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

}
