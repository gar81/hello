package com.automation.tests;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.groovy.control.InstanceOfVerifier;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.responsePOJOmodel.Data;
import com.automation.responsePOJOmodel.ListUsersResponsePOJO;
import com.automation.responsePOJOmodel.Support;
import com.automation.utilities.Helper;

public class ListUserTest extends BaseTest
{
	
	ListUsersResponsePOJO listUsersResponsePOJO;
	Data data;
	Support support;
	
	@BeforeClass
	public void initializeResponseClass() {
		listUsersResponsePOJO= new ListUsersResponsePOJO();
		data= new Data();
		support= new Support();		
		
	}
	
	
	@BeforeMethod
	public void setupEndPt()
	{
		request.basePath("/api/users");
	}

	@Test
	public void listUserTest()  //JSON CONVERSION TO JAVA OBJECT I.E pojo- serialization
	{
		SoftAssert sft= new SoftAssert();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("page", 2);
		request.queryParams(queryParams);
		response = request.get();
		sft.assertEquals(response.getStatusCode(), 200);
		
		listUsersResponsePOJO = response.as(ListUsersResponsePOJO.class); //deserialization
		System.out.println(listUsersResponsePOJO.page);
		sft.assertEquals(listUsersResponsePOJO.page, 2);
		System.out.println(Helper.getValue("ID"));
		//System.out.println(TypeOf(Helper.getValue("id")));
		for(Data userData : listUsersResponsePOJO.getData()) {
			if(userData.getId()==Integer.valueOf(Helper.getValue("id"))) {
				sft.assertEquals(userData.getEmail(), Helper.getValue("Useremail"));
				sft.assertEquals(userData.getFirst_name(), Helper.getValue("Userfirst_name"));
				sft.assertEquals(userData.getLast_name(), Helper.getValue("Userlast_name"));
			}
		}
	}

}
