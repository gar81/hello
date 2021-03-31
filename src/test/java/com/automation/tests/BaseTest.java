package com.automation.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.APIConstants;
import com.automation.utilities.Helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseTest
{
	RequestSpecification request;
	Response response;
	
	@BeforeSuite
	public void loadProperties() {
		Helper.loadPropertiesData();
	} 
	
	@BeforeMethod
	public void requestSetup() {
		request= RestAssured.given();
		request.baseUri(APIConstants.BASEURI);	
	    response= null;	
	}

}
