package com.bhuvanesh.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bhuvanesh.utility.TestUtil;

public class TestBase {
  public static WebDriver driver;
  public static Properties prop;
  
  public TestBase() {
	  try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/bhuvanesh"
					+ "/config/BhuvaneshProperties.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
  }
  


public static void initialization() {
	  String browserName;
	  try {
		  browserName=prop.getProperty("browser");
		  if(browserName.equalsIgnoreCase("chrome")) {
			  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+File.separator+"resource"+File.separator+"driver"+File.separator+"chrome"+File.separator+"chromedriver.exe");
			  driver=new ChromeDriver();
		  }
		      driver.get(prop.getProperty("URL"));
			  driver.manage().window().maximize();
			  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIME));
		     
		
	  }
	  catch(Exception ex) {
		  ex.printStackTrace();
	  }
  }

} 