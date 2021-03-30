package com.automation.tests;

import org.testng.annotations.BeforeMethod;

import com.automation.utilities.APIConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest
{
	RequestSpecification request;
	Response response;
	
	@BeforeMethod
	public void requestSetup() {
		request= RestAssured.given();
		request.baseUri(APIConstants.BASEURI);	
	    response= null;	
	}

}
