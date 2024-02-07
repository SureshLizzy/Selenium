package com.topics.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Alert {

	public static void main(String[] args) {
//		ChromeOptions ops = new ChromeOptions();
//		ops.addArguments("--remote-allow-origins=*");
		EdgeOptions ops = new EdgeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new EdgeDriver(ops);
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
	}
}
