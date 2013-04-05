/* IChaiBean.java
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
package com.pscu.mchaiwala.service.ejb;

import java.util.List;

import com.pscu.mchaiwala.model.ChaiPayment;

/**
 * @author PPATEL
 */
public interface IChaiBean {

    public String makeChaiPayment(String username, Double amount, Integer vendorId);

    public List<ChaiPayment> getChaiPayments(String username);
}
