package com.Practice.Interview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTools {
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		

		driver.findElement(By.id("APjFqb")).sendKeys("Automation Tools", Keys.ENTER);
		

		driver.findElement(By.xpath("(//span[@class='LGwnxb'])[2]")).click();

		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='B0jnne']"));
		for (int i = 0; i < findElements.size(); i++) {
			System.out.println(findElements.get(i).getText());
		}
		System.out.println("-------------------------------");
		List<WebElement> findElements2 = driver.findElements(By.xpath("//span[@class='z1asCe QFl0Ff']"));
		if (findElements2.size() >= 0) {
			for (int i = 0; i < findElements2.size(); i++) {
				findElements2.get(i).click();
				List<WebElement> findElements3 = driver.findElements(By.xpath("//div[@class='Ze3gdf']"));
				for (int j = 0; j < findElements3.size(); j++) {
					String text = findElements3.get(j).getText();
					System.out.println(text);
				}

			}
		}

		
	}

}
