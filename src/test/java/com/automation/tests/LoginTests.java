package com.automation.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.requestPOJOmodel.LoginRequestPOJO;
import com.automation.responsePOJOmodel.Login200ResponsePOJO;
import com.automation.utilities.Helper;

//POST OPERATION
public class LoginTests extends BaseTest
{
    LoginRequestPOJO loginRequestPOJO;
    Login200ResponsePOJO login200ResponsePOJO;
    
    @BeforeClass //FOR MULTIPLE TESTS
    public void initializePOJOs() {
    	loginRequestPOJO= new LoginRequestPOJO();
    	login200ResponsePOJO= new Login200ResponsePOJO();
    }    
    
	@BeforeMethod
	public void setupEndPt()
	{
		request.basePath("/api/login");        
	}

	@Test
	public void loginValidation() //hit baseUri from basetest
	{
		SoftAssert sft= new SoftAssert();		
		//System.out.println(Helper.getValue("email").toString());
		loginRequestPOJO.setEmail(Helper.getValue("email").toString());
		loginRequestPOJO.setPassword(Helper.getValue("password").toString());
		request.body(loginRequestPOJO);
		response= request.post();
		
		sft.assertEquals(response.getStatusCode(), 200);
		sft.assertNotNull(login200ResponsePOJO.getToken());
		sft.assertAll(); 
	}

}
