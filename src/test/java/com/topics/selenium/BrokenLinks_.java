package com.topics.selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenLinks_ {

	public static void main(String[] args) throws IOException {
		EdgeOptions ops = new EdgeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(ops);
		driver.get("https://facebook.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
//		int count = 0;
//		for (int i = 0; i < links.size(); i++) {
//			WebElement link = links.get(i);
//			String linkAttribute = link.getAttribute("href");
//			
//			if (linkAttribute != null) {
//				URL url = new URL(linkAttribute);
//				URLConnection openConnection = url.openConnection();
//				HttpURLConnection httpURLConnection = (HttpURLConnection)openConnection;
//				int responseCode = httpURLConnection.getResponseCode();
//
//				if (responseCode != 200) {
//					System.out.println("Broken Links " + linkAttribute);
//					count++;
//				}
//			}
//		}
//
//		System.out.println("Broken Links count =" + count);
		
		
	////////////////////////////////////////////////////////////////
		System.out.println("-------------------------------");
		int count1 =0; 
		for (int i = 0; i < links.size(); i++) {
			Response response = RestAssured.given().get(links.get(i).getAttribute("href"));
			if (response.statusCode()!=200) {
				System.out.println("Broken link- "+links.get(i).getAttribute("href"));
				count1++;
			}
		}
		
		System.out.println("Broken link count- "+count1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
