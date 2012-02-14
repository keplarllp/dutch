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
public class GetCompetitivePricingForASINSample {

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


            System.out.println ("GetCompetitivePricingForASIN Action Response");
            System.out.println ("=============================================================================");

            System.out.println("    GetCompetitivePricingForASINResponse");
            java.util.List<GetCompetitivePricingForASINResult> getCompetitivePricingForASINResultList = response.getGetCompetitivePricingForASINResult();
            for (GetCompetitivePricingForASINResult getCompetitivePricingForASINResult : getCompetitivePricingForASINResultList) {
                System.out.println("        GetCompetitivePricingForASINResult");
            if (getCompetitivePricingForASINResult.isSetASIN()) {
                System.out.println("        ASIN");
                System.out.println("            " + getCompetitivePricingForASINResult.getASIN());
            }
            if (getCompetitivePricingForASINResult.isSetStatus()) {
                System.out.println("        status");
                System.out.println("            " + getCompetitivePricingForASINResult.getStatus());
            }
                if (getCompetitivePricingForASINResult.isSetProduct()) {
                    System.out.println("            Product");
                    Product  product = getCompetitivePricingForASINResult.getProduct();
                    if (product.isSetIdentifiers()) {
                        System.out.println("                Identifiers");
                        IdentifierType  identifiers = product.getIdentifiers();
                        if (identifiers.isSetMarketplaceASIN()) {
                            System.out.println("                    MarketplaceASIN");
                            ASINIdentifier  marketplaceASIN = identifiers.getMarketplaceASIN();
                            if (marketplaceASIN.isSetMarketplaceId()) {
                                System.out.println("                        MarketplaceId");
                                System.out.println("                            " + marketplaceASIN.getMarketplaceId());
                            }
                            if (marketplaceASIN.isSetASIN()) {
                                System.out.println("                        ASIN");
                                System.out.println("                            " + marketplaceASIN.getASIN());
                            }
                        }
                        if (identifiers.isSetSKUIdentifier()) {
                            System.out.println("                    SKUIdentifier");
                            SellerSKUIdentifier  SKUIdentifier = identifiers.getSKUIdentifier();
                            if (SKUIdentifier.isSetMarketplaceId()) {
                                System.out.println("                        MarketplaceId");
                                System.out.println("                            " + SKUIdentifier.getMarketplaceId());
                            }
                            if (SKUIdentifier.isSetSellerId()) {
                                System.out.println("                        SellerId");
                                System.out.println("                            " + SKUIdentifier.getSellerId());
                            }
                            if (SKUIdentifier.isSetSellerSKU()) {
                                System.out.println("                        SellerSKU");
                                System.out.println("                            " + SKUIdentifier.getSellerSKU());
                            }
                        }
                    }
                    if (product.isSetCompetitivePricing()) {
                        System.out.println("                CompetitivePricing");
                        CompetitivePricingType  competitivePricing = product.getCompetitivePricing();
                        if (competitivePricing.isSetCompetitivePrices()) {
                            System.out.println("                    CompetitivePrices");
                            CompetitivePriceList  competitivePrices = competitivePricing.getCompetitivePrices();
                            java.util.List<CompetitivePriceType> competitivePriceList = competitivePrices.getCompetitivePrice();
                            for (CompetitivePriceType competitivePrice : competitivePriceList) {
                                System.out.println("                        CompetitivePrice");
                            if (competitivePrice.isSetCondition()) {
                                System.out.println("                        condition");
                                System.out.println("                            " + competitivePrice.getCondition());
                            }
                            if (competitivePrice.isSetBelongsToRequester()) {
                                System.out.println("                        belongsToRequester");
                                System.out.println("                            " + competitivePrice.isBelongsToRequester());
                            }
                                if (competitivePrice.isSetCompetitivePriceId()) {
                                    System.out.println("                            CompetitivePriceId");
                                    System.out.println("                                " + competitivePrice.getCompetitivePriceId());
                                }
                                if (competitivePrice.isSetPrice()) {
                                    System.out.println("                            Price");
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
                                    if (price.isSetListingPrice()) {
                                        System.out.println("                                ListingPrice");
                                        MoneyType  listingPrice = price.getListingPrice();
                                        if (listingPrice.isSetCurrencyCode()) {
                                            System.out.println("                                    CurrencyCode");
                                            System.out.println("                                        " + listingPrice.getCurrencyCode());
                                        }
                                        if (listingPrice.isSetAmount()) {
                                            System.out.println("                                    Amount");
                                            System.out.println("                                        " + listingPrice.getAmount());
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
                            System.out.println();
                            NumberOfOfferListingsList  numberOfOfferListings = competitivePricing.getNumberOfOfferListings();
                            java.util.List<OfferListingCountType> offerListingCountList = numberOfOfferListings.getOfferListingCount();
                            for (OfferListingCountType offerListingCount : offerListingCountList) {
                                System.out.println("                        OfferListingCount");
                                System.out.println();
                            if (offerListingCount.isSetCondition()) {
                                System.out.println("                        condition");
                                System.out.println();
                                System.out.println("                            " + offerListingCount.getCondition());
                                System.out.println();
                            }
                            if (offerListingCount.isSetValue()) {
                                System.out.println("                        Value");
                                System.out.println();
                                System.out.println("                            " + offerListingCount.getValue());
                            }
                            }
                        }
                        if (competitivePricing.isSetTradeInValue()) {
                            System.out.println("                    TradeInValue");
                            System.out.println();
                            MoneyType  tradeInValue = competitivePricing.getTradeInValue();
                            if (tradeInValue.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + tradeInValue.getCurrencyCode());
                                System.out.println();
                            }
                            if (tradeInValue.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + tradeInValue.getAmount());
                                System.out.println();
                            }
                        }
                    }
                    if (product.isSetSalesRankings()) {
                        System.out.println("                SalesRankings");
                        System.out.println();
                        SalesRankList  salesRankings = product.getSalesRankings();
                        java.util.List<SalesRankType> salesRankList = salesRankings.getSalesRank();
                        for (SalesRankType salesRank : salesRankList) {
                            System.out.println("                    SalesRank");
                            System.out.println();
                            if (salesRank.isSetProductCategoryId()) {
                                System.out.println("                        ProductCategoryId");
                                System.out.println();
                                System.out.println("                            " + salesRank.getProductCategoryId());
                                System.out.println();
                            }
                            if (salesRank.isSetRank()) {
                                System.out.println("                        Rank");
                                System.out.println();
                                System.out.println("                            " + salesRank.getRank());
                                System.out.println();
                            }
                        }
                    }
                    if (product.isSetLowestOfferListings()) {
                        System.out.println("                LowestOfferListings");
                        System.out.println();
                        LowestOfferListingList  lowestOfferListings = product.getLowestOfferListings();
                        java.util.List<LowestOfferListingType> lowestOfferListingList = lowestOfferListings.getLowestOfferListing();
                        for (LowestOfferListingType lowestOfferListing : lowestOfferListingList) {
                            System.out.println("                    LowestOfferListing");
                            System.out.println();
                            if (lowestOfferListing.isSetQualifiers()) {
                                System.out.println("                        Qualifiers");
                                System.out.println();
                                QualifiersType  qualifiers = lowestOfferListing.getQualifiers();
                                if (qualifiers.isSetItemCondition()) {
                                    System.out.println("                            ItemCondition");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getItemCondition());
                                    System.out.println();
                                }
                                if (qualifiers.isSetItemSubcondition()) {
                                    System.out.println("                            ItemSubcondition");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getItemSubcondition());
                                    System.out.println();
                                }
                                if (qualifiers.isSetFulfillmentChannel()) {
                                    System.out.println("                            FulfillmentChannel");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getFulfillmentChannel());
                                    System.out.println();
                                }
                                if (qualifiers.isSetShipsDomestically()) {
                                    System.out.println("                            ShipsDomestically");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getShipsDomestically());
                                    System.out.println();
                                }
                                if (qualifiers.isSetShippingTime()) {
                                    System.out.println("                            ShippingTime");
                                    System.out.println();
                                    ShippingTimeType  shippingTime = qualifiers.getShippingTime();
                                    if (shippingTime.isSetMax()) {
                                        System.out.println("                                Max");
                                        System.out.println();
                                        System.out.println("                                    " + shippingTime.getMax());
                                        System.out.println();
                                    }
                                }
                                if (qualifiers.isSetSellerPositiveFeedbackRating()) {
                                    System.out.println("                            SellerPositiveFeedbackRating");
                                    System.out.println();
                                    System.out.println("                                " + qualifiers.getSellerPositiveFeedbackRating());
                                    System.out.println();
                                }
                            }
                            if (lowestOfferListing.isSetNumberOfOfferListingsConsidered()) {
                                System.out.println("                        NumberOfOfferListingsConsidered");
                                System.out.println();
                                System.out.println("                            " + lowestOfferListing.getNumberOfOfferListingsConsidered());
                                System.out.println();
                            }
                            if (lowestOfferListing.isSetSellerFeedbackCount()) {
                                System.out.println("                        SellerFeedbackCount");
                                System.out.println();
                                System.out.println("                            " + lowestOfferListing.getSellerFeedbackCount());
                                System.out.println();
                            }
                            if (lowestOfferListing.isSetPrice()) {
                                System.out.println("                        Price");
                                System.out.println();
                                PriceType  price1 = lowestOfferListing.getPrice();
                                if (price1.isSetLandedPrice()) {
                                    System.out.println("                            LandedPrice");
                                    System.out.println();
                                    MoneyType  landedPrice1 = price1.getLandedPrice();
                                    if (landedPrice1.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + landedPrice1.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (landedPrice1.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + landedPrice1.getAmount());
                                        System.out.println();
                                    }
                                }
                                if (price1.isSetListingPrice()) {
                                    System.out.println("                            ListingPrice");
                                    System.out.println();
                                    MoneyType  listingPrice1 = price1.getListingPrice();
                                    if (listingPrice1.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + listingPrice1.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (listingPrice1.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + listingPrice1.getAmount());
                                        System.out.println();
                                    }
                                }
                                if (price1.isSetShipping()) {
                                    System.out.println("                            Shipping");
                                    System.out.println();
                                    MoneyType  shipping1 = price1.getShipping();
                                    if (shipping1.isSetCurrencyCode()) {
                                        System.out.println("                                CurrencyCode");
                                        System.out.println();
                                        System.out.println("                                    " + shipping1.getCurrencyCode());
                                        System.out.println();
                                    }
                                    if (shipping1.isSetAmount()) {
                                        System.out.println("                                Amount");
                                        System.out.println();
                                        System.out.println("                                    " + shipping1.getAmount());
                                        System.out.println();
                                    }
                                }
                            }
                            if (lowestOfferListing.isSetMultipleOffersAtLowestPrice()) {
                                System.out.println("                        MultipleOffersAtLowestPrice");
                                System.out.println();
                                System.out.println("                            " + lowestOfferListing.getMultipleOffersAtLowestPrice());
                                System.out.println();
                            }
                        }
                    }
                }
                if (getCompetitivePricingForASINResult.isSetError()) {
                    System.out.println("            Error");
                    System.out.println();
                    com.amazonservices.mws.products.model.Error  error = getCompetitivePricingForASINResult.getError();
                    if (error.isSetType()) {
                        System.out.println("                Type");
                        System.out.println();
                        System.out.println("                    " + error.getType());
                        System.out.println();
                    }
                    if (error.isSetCode()) {
                        System.out.println("                Code");
                        System.out.println();
                        System.out.println("                    " + error.getCode());
                        System.out.println();
                    }
                    if (error.isSetMessage()) {
                        System.out.println("                Message");
                        System.out.println();
                        System.out.println("                    " + error.getMessage());
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
