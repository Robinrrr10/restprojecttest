package com.rob.myrestprojecttest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.rob.profilePojo.entry.ProfileResponse;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

	@Test
	public void testProfile() throws ClientProtocolException, IOException {
		System.out.println("Starting test case 1");
		long profileId = 12345;
		App app = new App();
		ProfileResponse profileResponse = app.getprofile(profileId);
		assertEquals(profileResponse.getStatus().getStatusCode(), 10001, "Failed with status code is not matching statusMessage:"+profileResponse.getStatus().getStatusMessage());
		assertEquals(profileResponse.getStatus().getStatusMessage(), "Profile received successfully", "Status message Failed");;
		System.out.println("Test case 1 completed");
	}
}
