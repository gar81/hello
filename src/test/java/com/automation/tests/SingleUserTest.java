package com.automation.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.responsePOJOmodel.SingleUsersResponsePOJO;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SingleUserTest extends BaseTest
{
	SingleUsersResponsePOJO singleUsersResponsePOJO;
	
	
	 @BeforeClass //FOR MULTIPLE TESTS
	    public void initializePOJOs() {
		 singleUsersResponsePOJO= new SingleUsersResponsePOJO();
	    }    
	 
	 
	 @BeforeMethod
		public void setupEndPt()
		{
			request.basePath("/api/users");  
			
		}
	    
	/* @Test
		public void singleUserValidation_id2() //hit baseUri from basetest
		{
			SoftAssert sft= new SoftAssert();	
			Map<String, Object> pathParam = new HashMap<String, Object>();
			pathParam.put("id", 2);
			request.queryParams(pathParam);
			response = request.get();
			sft.assertEquals(response.getStatusCode(), 200);			
			sft.assertAll(); 
		}*/
	 
	 @Test
		public void newsingleUserValidation_id2() //hit baseUri from basetest
		{
			SoftAssert sft= new SoftAssert();	
			
			RequestSpecification rs= RestAssured.given();
			Map<String, String> pathParam = new HashMap<String, String>();
			pathParam.put("username", "suresh");
			rs.pathParams(pathParam);
			//rs.baseUri("https://petstore.swagger.io");
			rs.basePath("https://petstore.swagger.io/v2/user​/{username}");
			System.out.println();
			
			
			
			Response response1 = rs.get();
			System.out.println(rs);
			sft.assertEquals(response1.getStatusCode(), 200);			
			sft.assertAll(); 
		}
	 
	

}
