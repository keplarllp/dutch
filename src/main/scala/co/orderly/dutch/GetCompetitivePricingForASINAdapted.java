package co.orderly.dutch;

import java.util.List;
import java.util.ArrayList;
import com.amazonservices.mws.products.*;
import com.amazonservices.mws.products.model.*;
import com.amazonservices.mws.products.mock.MarketplaceWebServiceProductsMock;

/**
 *
 * Get Competitive Pricing For ASIN  Samples
 *
 *
 */
public class GetCompetitivePricingForASINAdapted {

  /**
     * Get Competitive Pricing For ASIN  request sample
     * Gets competitive pricing and related information for a product identified by
     * the MarketplaceId and ASIN.
     *
     * @param service instance of MarketplaceWebServiceProducts service
     * @param request Action to invoke
     */
    public static void invokeGetCompetitivePricingForASIN(MarketplaceWebServiceProducts service, GetCompetitivePricingForASINRequest request) {
        try {

            GetCompetitivePricingForASINResponse response = service.getCompetitivePricingForASIN(request);

            java.util.List<GetCompetitivePricingForASINResult> getCompetitivePricingForASINResultList = response.getGetCompetitivePricingForASINResult();
            for (GetCompetitivePricingForASINResult getCompetitivePricingForASINResult : getCompetitivePricingForASINResultList) {
                if (getCompetitivePricingForASINResult.isSetProduct()) {
                    Product  product = getCompetitivePricingForASINResult.getProduct();
                    if (product.isSetIdentifiers()) {
                        IdentifierType  identifiers = product.getIdentifiers();
                        if (identifiers.isSetMarketplaceASIN()) {
                            System.out.println("                    MarketplaceASIN");
                            ASINIdentifier  marketplaceASIN = identifiers.getMarketplaceASIN();
                            if (marketplaceASIN.isSetASIN()) {
                                System.out.println("                        ASIN");
                                System.out.println("                            " + marketplaceASIN.getASIN());
                            }
                        }
                    }
                    if (product.isSetCompetitivePricing()) {
                        CompetitivePricingType  competitivePricing = product.getCompetitivePricing();
                        if (competitivePricing.isSetCompetitivePrices()) {
                           CompetitivePriceList  competitivePrices = competitivePricing.getCompetitivePrices();
                            java.util.List<CompetitivePriceType> competitivePriceList = competitivePrices.getCompetitivePrice();
                            for (CompetitivePriceType competitivePrice : competitivePriceList) {
                                if (competitivePrice.isSetPrice()) {
                                    PriceType  price = competitivePrice.getPrice();
                                    if (price.isSetLandedPrice()) {
                                        System.out.println("                                LandedPrice");
                                         
                                        MoneyType  landedPrice = price.getLandedPrice();
                                        if (landedPrice.isSetCurrencyCode()) {
                                            System.out.println("                                    CurrencyCode");
                                             
                                            System.out.println("                                        " + landedPrice.getCurrencyCode());
                                             
                                        }
                                        if (landedPrice.isSetAmount()) {
                                            System.out.println("                                    Amount");
                                             
                                            System.out.println("                                        " + landedPrice.getAmount());
                                             
                                        }
                                    }
                                    if (price.isSetShipping()) {
                                        System.out.println("                                Shipping");
                                         
                                        MoneyType  shipping = price.getShipping();
                                        if (shipping.isSetCurrencyCode()) {
                                            System.out.println("                                    CurrencyCode");
                                             
                                            System.out.println("                                        " + shipping.getCurrencyCode());
                                             
                                        }
                                        if (shipping.isSetAmount()) {
                                            System.out.println("                                    Amount");
                                             
                                            System.out.println("                                        " + shipping.getAmount());
                                             
                                        }
                                    }
                                }
                            }
                        }
                        if (competitivePricing.isSetNumberOfOfferListings()) {
                            System.out.println("                    NumberOfOfferListings");
                             
                            NumberOfOfferListingsList  numberOfOfferListings = competitivePricing.getNumberOfOfferListings();
                            java.util.List<OfferListingCountType> offerListingCountList = numberOfOfferListings.getOfferListingCount();
                            for (OfferListingCountType offerListingCount : offerListingCountList) {
                                System.out.println("                        OfferListingCount");
                                 
                                if (offerListingCount.isSetCondition()) {
                                    System.out.println("                        condition");
                                     
                                    System.out.println("                            " + offerListingCount.getCondition());
                                     
                                }
                                if (offerListingCount.isSetValue()) {
                                    System.out.println("                        Value");
                                     
                                    System.out.println("                            " + offerListingCount.getValue());
                                }
                            }
                        }
                    }
                }
                if (getCompetitivePricingForASINResult.isSetError()) {
                    System.out.println("            Error");
                     
                    com.amazonservices.mws.products.model.Error  error = getCompetitivePricingForASINResult.getError();
                    if (error.isSetType()) {
                        System.out.println("                Type");
                         
                        System.out.println("                    " + error.getType());
                         
                    }
                    if (error.isSetCode()) {
                        System.out.println("                Code");
                         
                        System.out.println("                    " + error.getCode());
                         
                    }
                    if (error.isSetMessage()) {
                        System.out.println("                Message");
                         
                        System.out.println("                    " + error.getMessage());
                         
                    }
                }
            }
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
