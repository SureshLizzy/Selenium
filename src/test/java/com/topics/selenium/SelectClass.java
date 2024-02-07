package com.topics.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException, AWTException {
		
		Select s;
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement fName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		fName.sendKeys("Suresh");
		
		WebElement lName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		lName.sendKeys("Velraj");
		
		WebElement address = driver.findElement(By.xpath("//textarea[@ng-model='Adress']"));
		address.sendKeys("Avaniyapuram,Madurai");
		
		WebElement email = driver.findElement(By.xpath("//input[@ng-model='EmailAdress']"));
		email.sendKeys("sureshvelraj@gmail.com");
		
		WebElement phone = driver.findElement(By.xpath("//input[@ng-model='Phone']"));
		phone.sendKeys("9965266386");
		
		WebElement rdoBtn = driver.findElement(By.xpath("//input[@value='Male']"));
		rdoBtn.click();
		
		WebElement chkBoxHobby1 = driver.findElement(By.xpath("//input[@value='Cricket']"));
		chkBoxHobby1.click();
		
		WebElement chkBoxHobby2 = driver.findElement(By.xpath("//input[@value='Movies']"));
		chkBoxHobby2.click();
		
		WebElement txtBoxLanguages = driver.findElement(By.id("msdd"));
		txtBoxLanguages.click();
		
//		Robot r = new Robot();
//		for (int i = 0; i < 6; i++) {
//			r.keyPress(java.awt.event.KeyEvent.VK_DOWN);
//			r.keyRelease(KeyEvent.VK_DOWN);
//		}
//	
//	r.keyPress(KeyEvent.VK_ENTER);
//	r.keyRelease(KeyEvent.VK_ENTER);
		
		
		WebElement clkLanguage = driver.findElement(By.xpath("//a[text()='English']"));
		clkLanguage.click();
		
		WebElement textBoxCountry = driver.findElement(By.className("select2-selection__arrow"));
		textBoxCountry.click();
		WebElement clkCountry = driver.findElement(By.xpath("//li[text()='India']"));
		clkCountry.click();
		
		WebElement btnSubmit = driver.findElement(By.id("submitbtn"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", btnSubmit);
		
		WebElement ddnSkills = driver.findElement(By.id("Skills"));
		s=new Select(ddnSkills);
		s.selectByValue("APIs");
		
		WebElement ddnYearBox = driver.findElement(By.id("yearbox"));
		s=new Select(ddnYearBox);
		s.selectByValue("1928");
		
		WebElement ddnMonth = driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
		s=new Select(ddnMonth);
		s.selectByValue("July");
		
		WebElement ddnDate = driver.findElement(By.id("daybox"));
		s=new Select(ddnDate);
		s.selectByValue("17");
		
		WebElement txtFisrtPassword = driver.findElement(By.id("firstpassword"));
		txtFisrtPassword.sendKeys("Suresh@123");
		
		WebElement txtSecondPassword = driver.findElement(By.id("secondpassword"));
		txtSecondPassword.sendKeys("Suresh@123");
		
//		WebElement btnSubmit = driver.findElement(By.id("submitbtn"));
		btnSubmit.click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	}
}

