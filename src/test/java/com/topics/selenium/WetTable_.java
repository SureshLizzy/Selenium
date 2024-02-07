package com.topics.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WetTable_ {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		
		
		WebElement table = driver.findElement(By.id("customers"));
		List<WebElement> tRow = table.findElements(By.tagName("tr"));
		
		System.out.println(tRow.size());
		for (int i = 1; i < 2; i++) {
			WebElement row = tRow.get(i);
			List<WebElement> tData = row.findElements(By.tagName("td"));
			System.out.println(tData.size());
		}
		System.out.println();
		
		
	}
}
