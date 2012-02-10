/******************************************************************************* 
 *  Copyright 2008-2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *  Licensed under the Apache License, Version 2.0 (the "License"); 
 *  
 *  You may not use this file except in compliance with the License. 
 *  You may obtain a copy of the License at: http://aws.amazon.com/apache2.0
 *  This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR 
 *  CONDITIONS OF ANY KIND, either express or implied. See the License for the 
 *  specific language governing permissions and limitations under the License.
 * ***************************************************************************** 
 * 
 *  Marketplace Web Service Products Java Library
 *  API Version: 2011-10-01
 * 
 */





package com.amazonservices.mws.products.samples;

import com.amazonservices.mws.products.MarketplaceWebServiceProductsConfig;

/**
 * Configuration used in  Marketplace Web Service Products  samples
 */
final public class ProductsConfig {
	/************************************************************************
	 * Set Access Key ID, Secret Acess Key ID, Seller ID, etc.
	 ***********************************************************************/
	public static final String accessKeyId = "0PB842RXQVXW37N4ZTR2";
	public static final String secretAccessKey = "jpheIKQjhSbzYlTbMN5QrFHbeyQ8mR9Nh9c/+HsN";
	public static final String applicationName = "<Application Name>";
	public static final String applicationVersion = "<Application Version>";

	public static final String sellerId = "A1XQIUJ2945E6";
	public static final String marketplaceId = "ATVPDKIKX0DER";

	public static MarketplaceWebServiceProductsConfig config = new MarketplaceWebServiceProductsConfig();

	static {

	    //
	    // IMPORTANT: Uncomment out the appropriate line for the country you wish 
	    // to sell in:
	    // 
	    // United States:
	     config.setServiceURL("https://mws.amazonservices.com/Products/2011-10-01");
	    //
	    // Canada:
	    // config.setServiceURL("https://mws.amazonservices.ca/Products/2011-10-01");
	    //
	    // Europe:
	    // config.setServiceURL("https://mws-eu.amazonservices.com/Products/2011-10-01");
	    //
	    // Japan:
	    // config.setServiceURL("https://mws.amazonservices.jp/Products/2011-10-01");
	    //
	    // China:
	    // config.setServiceURL("https://mws.amazonservices.com.cn/Products/2011-10-01");
	    //
		/************************************************************************
		 * You can also try advanced configuration options. Available options are:
		 * 
		 * - Signature Version - Proxy Host and Proxy Port - User Agent String to be
		 * sent to Marketplace Web Service
		 *************************************************************************/
	}

}