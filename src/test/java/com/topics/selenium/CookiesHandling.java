package com.topics.selenium;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookiesHandling {

	//A HTTP cookie is comprised of information about the user and their preferences. It is the small piece of data from the web application and stored in the web browser while the user is browsing that website
	//Basically, each cookie is associated with a name, value, domain, expiry, status of whether it is secure or not. In order to validate client, a server parses all these value in a cookie
	//It stores information using key and value pair
	WebDriver driver;
	Cookie cookie;
	private void browserSetup() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(ops);
	}
	
	private void webApplication() {
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}
	
	private void getCookies_() {
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		System.out.println("---------------------");
	}
	
	private void addCookie_() {
		 cookie = new Cookie("Suresh", "QA");
		driver.manage().addCookie(cookie);
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		System.out.println("---------------------");
	}
	
	private void getCookieNamed_() {
		driver.manage().getCookieNamed("Suresh");
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		System.out.println("---------------------");
	}
	
	private void deleteCookie_() {
		driver.manage().deleteCookie(cookie);
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		System.out.println("---------------------");
	}
	
	private void deleteCookieNamed_() {
		driver.manage().deleteCookieNamed("Suresh");
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		System.out.println("---------------------");
	}
	
	private void deleteAllCookie_() {
		driver.manage().deleteAllCookies();
		Set<Cookie> cookies = driver.manage().getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
		}
		System.out.println("---------------------");
	}
	
	public static void main(String[] args) {
		CookiesHandling cookiesHandling = new CookiesHandling();
		cookiesHandling.browserSetup();
		cookiesHandling.webApplication();
		cookiesHandling.getCookies_();
		cookiesHandling.addCookie_();
//		cookiesHandling.getCookieNamed_();
//		cookiesHandling.deleteCookie_();
//		cookiesHandling.addCookie_();
//		cookiesHandling.deleteCookieNamed_();
//		cookiesHandling.deleteAllCookie_();
	}
	
}
