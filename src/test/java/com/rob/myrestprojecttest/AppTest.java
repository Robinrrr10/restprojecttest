package com.rob.myrestprojecttest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.robinrrr10.profilePojo.entry.ProfileResponse;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	
	public String envName;
	
	@BeforeClass
	public void setupEnvironment() {
		String envJenName = null;
		envJenName= System.getenv("host");
		System.out.println("Given envJenName:"+envJenName);
		if(envJenName != null && !envJenName.isEmpty()) {
			System.out.println("Env is given");
			envName = envJenName;
		}else {
			System.out.println("Env is NOT given");
			envName = "localhost";
		}
	}

	@Test(description="Test profile successfull")
	public void testSuccessfullProfile() throws ClientProtocolException, IOException {
		System.out.println("Starting test case 1");
		long profileId = 12345;
		App app = new App();
		ProfileResponse profileResponse = app.getprofile(profileId, envName);
		System.out.println("ProfileResponse:"+profileResponse);
		assertEquals(profileResponse.getStatus().getStatusCode(), 10001, "Failed with status code is not matching statusMessage:"+profileResponse.getStatus().getStatusMessage());
		assertEquals(profileResponse.getStatus().getStatusMessage(), "Profile received successfully", "Status message Failed");;
		System.out.println("Test case 1 completed");
	}
	
	@Test(description="Test profile with invalid")
	public void testProfileWithInvalid() throws ClientProtocolException, IOException {
		System.out.println("Starting test case 2");
		long profileId = 12346;
		App app = new App();
		ProfileResponse profileResponse = app.getprofile(profileId, envName);
		System.out.println("ProfileResponse:"+profileResponse);
		assertEquals(profileResponse.getStatus().getStatusCode(), 2003, "Failed with status code is not matching statusMessage:"+profileResponse.getStatus().getStatusMessage());
		assertEquals(profileResponse.getStatus().getStatusMessage(), "Profile not available", "Status message Failed");;
		System.out.println("Test case 2 completed");
	}
}
