package com.mb.io.connect.backend.services;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.*;

public class ServiceEndpoint {
    private static final String OAUTH = "/authorizationserver/oauth/token";
    private static final String CART = "/dcp-api/v2/dcp-mbc-ca/users/ciam_user_9c365b72-aae9-40fb-99ad-d29c3fcb2c78/carts/current";
    //https://dcp-connect-int.api.mercedes-benz.com/dcp-api/v2/dcp-mbc-ch/users/current/connect/productdetails?fields=FULL&fin=WDD1770461Z000037&lang=en_CH
    //testuser.int.CH.001@mbox.mercedes-benz.io - ciam_user_e371f2c0-ebd9-4e00-85f2-62c64dc5ef2a
    private static final String PRODUCT = "/dcp-api/v2/dcp-mbc-ch/users/ciam_user_e371f2c0-ebd9-4e00-85f2-62c64dc5ef2a/connect/productdetails";

    EnvironmentVariables environmentVariables;
    String urlEndpoint;

    public String getUrlEndpoint(String endpointRequired) {
         switch (endpointRequired) {
            case "oauth":
                urlEndpoint = urlForEndpoint(OAUTH);
                break;
            case "cart":
                 urlEndpoint = urlForEndpoint(CART);
                 break;
             case "product":
                 urlEndpoint = urlForEndpoint(PRODUCT);
                 break;
         }
        return urlEndpoint;
    }

    public String apiBase(){
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("api.base.url");
    }

    public String getpropertyValue(String attribute){
        return EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(attribute);
    }

    private String urlForEndpoint (String endpoint) {
        return apiBase()+ endpoint ;
    }

    public Response callHTTPPost(String endPoint,Map<String,String> query,String state){

        Response response;
        System.out.println("Request URL"+endPoint);
        if(state != null)
            response = SerenityRest.given().relaxedHTTPSValidation().queryParams(query).body(state).post(endPoint);
        else
            response = SerenityRest.given().relaxedHTTPSValidation().queryParams(query).post(endPoint);

        System.out.println("Serenity Response body"+response.body().toString());
        System.out.println("Serenity Response status code"+response.statusCode());
        System.out.println("Serenity Response content type"+response.getContentType());
        System.out.println("Serenity Response content "+response.body().asString());

        return response;
    }

    public Response callHTTPGet(String endPoint,Map<String,String> path, Map<String,String> query,String token) throws Exception{

       Response response;
       System.out.println(query);
       System.out.println(endPoint);
        if(path != null && query == null){
            response = SerenityRest.given().relaxedHTTPSValidation().auth().oauth2(token).queryParams(query).pathParams(path).get(endPoint);
            return response;
        }
        else
        {
            response = SerenityRest.given().relaxedHTTPSValidation().auth().oauth2(token).queryParams(query).get(endPoint);
            return response;
        }
    }
}

