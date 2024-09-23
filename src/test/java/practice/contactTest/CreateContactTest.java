package practice.contactTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateContactTest {
@Test
public void test() throws Throwable
{
	FileInputStream fis = new FileInputStream("C:\\Users\\SHH\\Desktop\\New folder\\SeleniumCRMGUIFramework\\src\\test\\resources\\vtigercommandata.properties");

	Properties probj = new Properties();
	probj.load(fis);
	String BROWSER = probj.getProperty("browser");
	String URL = probj.getProperty("url");
	String USERNAME = probj.getProperty("username");
	String PASSWORD = probj.getProperty("password"); 
	
	Random r=new Random();
	int randominf=r.nextInt(1000); 
	
	
	FileInputStream fis1=new FileInputStream("C:\\Users\\SHH\\Desktop\\New folder\\SeleniumCRMGUIFramework\\src\\test\\resources\\vtigertestScript.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	Sheet sh=wb.getSheet("Contacts");
	Row row=sh.getRow(1);
	String orgname=row.getCell(2).toString()+randominf;
	
	wb.close();
	
	// launch browser
WebDriver driver=new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
driver.get(URL);

//login to app
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

//navigate to Cantacts Module

driver.findElement(By.linkText("Contacts")).click();

driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(orgname);
driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();

//verify
String element=driver.findElement(By.id("dtlview_Last Name")).getText();

if(element.equals(orgname))
{
	System.out.println(orgname +"Created==PASS");
}
else
{
	System.out.println(orgname +" Not Created==FAIL");
}

}
}
