package com.automation.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.responsePOJOmodel.Data;
import com.automation.responsePOJOmodel.ListUsersResponsePOJO;
import com.automation.responsePOJOmodel.Support;
import com.automation.utilities.Helper;

//GET OPERATION
public class ListUserTest extends BaseTest
{

	ListUsersResponsePOJO listUsersResponsePOJO;
	Data data;
	Support support;

	@BeforeClass
	public void initializeResponseClass()
	{
		listUsersResponsePOJO = new ListUsersResponsePOJO();
		data = new Data();
		support = new Support();
	}

	@BeforeMethod
	public void setupEndPt()
	{
		request.basePath("/api/users");
	}

	@Test
	public void listUserTest() // JSON CONVERSION TO JAVA OBJECT I.E pojo- serialization
	{
		SoftAssert sft = new SoftAssert();
		Map<String, Object> queryParams = new HashMap<String, Object>();
		queryParams.put("page", 2);
		request.queryParams(queryParams);
		response = request.get();
		sft.assertEquals(response.getStatusCode(), 200);

		listUsersResponsePOJO = response.as(ListUsersResponsePOJO.class); // deserialization
		sft.assertEquals(listUsersResponsePOJO.page, 2);
		for (Data userData : listUsersResponsePOJO.getData())
		{
			if (userData.getId() == Integer.parseInt(Helper.getValue("ID")))
			{
				Assert.assertEquals(userData.getEmail(), Helper.getValue("Useremail"));
				Assert.assertEquals(userData.getFirst_name(), Helper.getValue("Userfirst_name"));
				Assert.assertEquals(userData.getLast_name(), Helper.getValue("Userlast_name"));
			}
		}
		
		Assert.assertTrue(listUsersResponsePOJO.getSupport().getUrl().contains(Helper.getValue("url")));
		sft.assertAll();
	}

}
