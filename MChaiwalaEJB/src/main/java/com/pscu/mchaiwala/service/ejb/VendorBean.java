/* VendorBean.java
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

package com.pscu.mchaiwala.service.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.pscu.mchaiwala.model.Vendor;

@Stateless
public class VendorBean implements VendorBeanLocal {

    public static List<Vendor> vendorList = new ArrayList<Vendor>();

    static {
        final Vendor moJoe = new Vendor();
        moJoe.setVendorId(1);
        moJoe.setVendorName("MoJoe Cafe");
        vendorList.add(moJoe);

        final Vendor bookFair = new Vendor();
        bookFair.setVendorId(2);
        bookFair.setVendorName("Book Fair Vendor");
        vendorList.add(bookFair);
    }

    public List<Vendor> getAllVendors() {
        // TODO Auto-generated method stub
        return vendorList;
    }

    public Vendor getVendorByID(Integer vendorID) {
        // TODO Auto-generated method stub
        for (final Vendor vendor : vendorList) {
            if (vendor.getVendorId().intValue() == vendorID.intValue()) {
                return vendor;
            }
        }

        return null;

    }
}
