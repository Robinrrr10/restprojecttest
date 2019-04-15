package com.rob.myrestprojecttest;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	
	public ProfileResponse getprofile(long profileId) throws ClientProtocolException, IOException {
		System.out.println("Hello World!");
		HttpClient client = HttpClients.createDefault();
		HttpGet postRequest = new HttpGet("http://localhost:8080/myrestproject/v1/profile/"+profileId);
		HttpResponse response = client.execute(postRequest);
		System.out.println("status code is" + response.getStatusLine().getStatusCode());
		HttpEntity entity = response.getEntity();
		String ss = EntityUtils.toString(entity);
		System.out.println("Result is==>" + ss);

		ObjectMapper obj = new ObjectMapper();
		ProfileResponse profileResponse = obj.readValue(ss, ProfileResponse.class);
		return profileResponse;
	}
}
