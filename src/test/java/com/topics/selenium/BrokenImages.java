package com.topics.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BrokenImages {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
	 
		EdgeOptions ops = new EdgeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(ops);
		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		List<WebElement> images = driver.findElements(By.tagName("img"));
		// int count=0;
		// for (int i = 0; i < images.size(); i++) {
		// WebElement image = images.get(i);
		// String imageAttribute = image.getAttribute("src");
		//
		// if(imageAttribute!=null) {
		// URL url = new URL(imageAttribute);
		// URLConnection urlConnection = url.openConnection();
		// HttpURLConnection http = (HttpURLConnection)urlConnection;
		// int responseCode = http.getResponseCode();
		//
		// if(responseCode!=200) {
		// System.out.println("Broken Images "+imageAttribute);
		// count++;
		// }
		// }
		// }
		// System.out.println("Broken images Count: "+count);

		// using RestAssured
		int count=0;
		for (int i = 0; i < images.size(); i++) {
			Response response = RestAssured.given().contentType("application/json")
					.get(images.get(i).getAttribute("src"));
//			System.out.println(response.getStatusCode());
			
			//using width
//			if (images.get(i).getAttribute("naturalWidth").equals(0)) {
//				System.out.println(images.get(i).getAttribute("src")+" is borken");
//			}else {
//				System.out.println(images.get(i).getAttribute("src")+" is not broken");
//			}
			
			//using code
			if ((response.getStatusCode()!=200)) {
				System.out.println("Broken image- "+images.get(i).getAttribute("src"));
				count++;
			}
		}
		System.out.println("Broken image count- "+count);
	}
}
