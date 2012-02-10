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

import java.util.List;
import java.util.ArrayList;
import com.amazonservices.mws.products.*;
import com.amazonservices.mws.products.model.*;
import com.amazonservices.mws.products.mock.MarketplaceWebServiceProductsMock;

/**
 *
 * Get Product Categories For ASIN  Samples
 *
 *
 */
public class GetProductCategoriesForASINSample {

    /**
     * Just add few required parameters, and try the service
     * Get Product Categories For ASIN functionality
     *
     * @param args unused
     */
    public static void main(String... args) {
        
        MarketplaceWebServiceProducts service = new MarketplaceWebServiceProductsClient(
					ProductsConfig.accessKeyId, 
					ProductsConfig.secretAccessKey, 
					ProductsConfig.applicationName, 
					ProductsConfig.applicationVersion, 
					ProductsConfig.config);
 
        /************************************************************************
         * Uncomment to try out Mock Service that simulates Marketplace Web Service Products 
         * responses without calling Marketplace Web Service Products  service.
         *
         * Responses are loaded from local XML files. You can tweak XML files to
         * experiment with various outputs during development
         *
         * XML files available under com/amazonservices/mws/products/mock tree
         *
         ***********************************************************************/
        // MarketplaceWebServiceProducts service = new MarketplaceWebServiceProductsMock();

        /************************************************************************
         * Setup request parameters and uncomment invoke to try out 
         * sample for Get Product Categories For ASIN 
         ***********************************************************************/
         GetProductCategoriesForASINRequest request = new GetProductCategoriesForASINRequest();
         request.setSellerId(ProductsConfig.sellerId);
        
         // @TODO: set request parameters here

         invokeGetProductCategoriesForASIN(service, request);

    }


                                                        
    /**
     * Get Product Categories For ASIN  request sample
     * Gets categories information for a product identified by
     * the MarketplaceId and ASIN.
     *   
     * @param service instance of MarketplaceWebServiceProducts service
     * @param request Action to invoke
     */
    public static void invokeGetProductCategoriesForASIN(MarketplaceWebServiceProducts service, GetProductCategoriesForASINRequest request) {
        try {
            
            GetProductCategoriesForASINResponse response = service.getProductCategoriesForASIN(request);

            
            System.out.println ("GetProductCategoriesForASIN Action Response");
            System.out.println ("=============================================================================");
            System.out.println ();

            System.out.println("    GetProductCategoriesForASINResponse");
            System.out.println();
            if (response.isSetGetProductCategoriesForASINResult()) {
                System.out.println("        GetProductCategoriesForASINResult");
                System.out.println();
                GetProductCategoriesForASINResult  getProductCategoriesForASINResult = response.getGetProductCategoriesForASINResult();
                java.util.List<Categories> selfList = getProductCategoriesForASINResult.getSelf();
                for (Categories self : selfList) {
                    System.out.println("            Self");
                    System.out.println();
                    if (self.isSetProductCategoryId()) {
                        System.out.println("                ProductCategoryId");
                        System.out.println();
                        System.out.println("                    " + self.getProductCategoryId());
                        System.out.println();
                    }
                }
            } 
            if (response.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata  responseMetadata = response.getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                " + responseMetadata.getRequestId());
                    System.out.println();
                }
            } 
            System.out.println();

           
        } catch (MarketplaceWebServiceProductsException ex) {
            
            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }
    }
    
}
