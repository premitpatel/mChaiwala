/* ChaiBean.java
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

package com.pscu.mchaiwala.service.ejb;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.pscu.mchaiwala.model.ChaiPayment;
import com.pscu.mchaiwala.model.Vendor;

@Stateless
public class ChaiBean implements ChaiBeanLocal, ChaiBeanRemote {

    // map containing employee id and ChaiPayments.
    private static List<ChaiPayment> chaiPayments = new ArrayList<ChaiPayment>();
    @EJB
    VendorBeanLocal                  vendorBean;

    public String makeChaiPayment(String username, Double amount, Integer vendorId) {
        // TODO Auto-generated method stub
        final Vendor vendor = vendorBean.getVendorByID(vendorId);

        final ChaiPayment cPayment = new ChaiPayment();
        cPayment.setDate(DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()));
        cPayment.setAmount(amount);
        cPayment.setUsername(username);
        cPayment.setVendor(vendor);
        chaiPayments.add(cPayment);

        try {
            final FileWriter writer = new FileWriter("N:\\IT\\Div Common\\mobeanstest.csv", true);
            writer.append(username).append(",").append(amount.toString()).append(",").append(cPayment.getDate()).append(",").append(vendorId.toString())
                            .append("\n");
            writer.flush();
            writer.close();

        } catch (final IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return UUID.randomUUID().toString();
    }

    public List<ChaiPayment> getChaiPayments(String username) {
        // TODO Auto-generated method stub

        if (username == null) {
            return chaiPayments;
        } else {
            final List<ChaiPayment> chaiPmts = new ArrayList<ChaiPayment>();
            for (final ChaiPayment chaiPayment : chaiPayments) {
                if (chaiPayment.getUsername().equals(username)) {
                    chaiPmts.add(chaiPayment);
                }
            }
            return chaiPmts;
        }
    }
}
