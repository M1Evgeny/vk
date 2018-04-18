package by.htp.vk.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Properties;

import org.apache.http.client.utils.URIBuilder;

import com.google.gson.Gson;


public class Main {
	protected static Properties properties = new Properties();
	private static URIBuilder createPostUrl;
	private static String scheme = "https";
	private static String hostName = "api.vk.com";
	private static String methodWallPost = "/method/wall.post";
	private static String valueUserId = "381108928";
	private static String valueAccess = "0";
	private static String vaueToken = "904da13c62ef685c2d17cdd3f3fb8430dcb1e6f23311809ba5b79e18fa4e97334dc30da82610f31b575ba";
	private static String valueVersion = "3.0";


	public static void main(String[] args) throws URISyntaxException, MalformedURLException {
		try {
			properties.load(new FileInputStream(new File("src/test/resources/credentials.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(properties.getProperty("vk.login"));
		System.out.println(properties.getProperty("vk.pass"));

		
		createPostUrl = new URIBuilder();
		createPostUrl.setScheme(scheme);
		createPostUrl.setHost(hostName);
		createPostUrl.setPath(methodWallPost);
		createPostUrl.addParameter("owner_id", valueUserId);
		createPostUrl.addParameter("friends_only", valueAccess);
		createPostUrl.addParameter("message", "message_text");
		createPostUrl.addParameter("access_token", vaueToken);
		createPostUrl.addParameter("v", valueVersion);
			System.out.println(createPostUrl.build().toURL());
		
	}

}
