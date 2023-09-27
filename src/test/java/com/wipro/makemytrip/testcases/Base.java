package com.wipro.makemytrip.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Base {
	public static WebDriver driver;
	public Properties prop;
	public Properties prop1;
	public static ExtentReports extent;
	public static ExtentTest test;
	public Logger logger;
	public Base() {

	
		File src=new File("F:\\testing workspaces\\jenkins\\makemytrip\\src\\main\\java\\com\\wipro\\makemytrip\\config\\configuration.properties");
	try {
		FileInputStream fis1=new FileInputStream("F:\\testing workspaces\\jenkins\\makemytrip\\log4j2.properties");
	
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try {
			FileInputStream fis=new FileInputStream(src);
			prop=new Properties();
			try {
				prop.load(fis);
			} catch (IOException e) {
				System.out.println("error message is" + e.getMessage());
			
			}
		} catch (FileNotFoundException e) {
			System.out.println("error message is" + e.getMessage());
		}
	}
	public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
		
		if(browserName.equalsIgnoreCase("chrome")) {
			
			driver = new ChromeDriver();
			//logger.info("Chrome Driver Launched");
		}else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","F:\\testing workspaces\\jenkins\\Shopping1\\drivers\\geckodriver.exe" );
			
			driver = new FirefoxDriver();
			//logger.info("Firefox Driver Launched");
		}else if(browserName.equalsIgnoreCase("edge")) {
			
			driver = new EdgeDriver();
			//logger.info("Edge Driver Launched");
		}else if(browserName.equalsIgnoreCase("safari")) {
			
			driver = new SafariDriver();
			logger.info("safari Driver Launched");
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("BaseURL"));
	
		
	return driver;
	
}
	public String Get_Browsername() {
		String url=prop.getProperty("browser");
		return url;
		
	}
	
	public static class ExtentReporter {
		
		public static ExtentReports generateExtentReport() {
			
			ExtentReports extentReport = new ExtentReports();

			
			File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
			
			sparkReporter.config().setTheme(Theme.DARK);
			sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
			sparkReporter.config().setDocumentTitle("TN Automation Report");
			sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
			
			extentReport.attachReporter(sparkReporter);
			
			Properties configProp = new Properties();
			File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\wipro\\shopping1\\config\\configuration.properties");
			
			try {
				FileInputStream fisConfigProp = new FileInputStream(configPropFile);
				configProp.load(fisConfigProp);
			}catch(Throwable e) {
				e.printStackTrace();
			}
			
			extentReport.setSystemInfo("Application URL",configProp.getProperty("url"));
			extentReport.setSystemInfo("Browser Name",configProp.getProperty("browserName"));
			extentReport.setSystemInfo("Email",configProp.getProperty("validEmail"));
			extentReport.setSystemInfo("Password",configProp.getProperty("validPassword"));
			extentReport.setSystemInfo("Operating System",System.getProperty("os.name"));
			extentReport.setSystemInfo("sai",System.getProperty("user.name"));
			extentReport.setSystemInfo("Java Version",System.getProperty("java.version"));
			
			return extentReport;
		}

	}

	
}
