package org.flipkart;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class tvPurchase {
	static WebDriver Driver; 
	static String text;
	static String text1;
	@BeforeClass
    public static void BrowserLaunch() {
		System.setProperty("webdriver.edge.driver", "C:\\Users\\lenovo\\eclipse-workspace\\UniversityIformation\\Driver\\msedgedriver.exe");
		 Driver = new EdgeDriver();
		String url = ( "https://www.flipkart.com/");
		Driver.get(url);
	}
	@AfterClass
	 public static void Browserquit() {
		Driver.quit();
			System.out.println("browserquit");
		}
	 @Test
	 public void method1() {
			WebElement login = Driver.findElement(By.xpath("//button[text()='✕']"));
		    login.click(); 
	 }
	 @Test
	 public void method2() {
		 WebElement search = Driver.findElement(By.name("q"));
		 search.sendKeys("tv");
	 }
	 @Test
	public void method3() throws Throwable {
		  Driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();
		  Thread.sleep(4000);
		  text = Driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).getText();
		  System.out.println(text);
		  File f = new File("C:\\Users\\lenovo\\eclipse-workspace\\FrameWork.Junit\\src\\test\\resources\\ExcelWrite2.xlsx");
			Workbook W = new XSSFWorkbook();
			Sheet s = W.createSheet("Excel");
			Row r = s.createRow(0);
			Cell c = r.createCell(0);
			c.setCellValue(text);
			
			FileOutputStream f1 = new FileOutputStream(f);
			W.write(f1);
	 }
	 @Test
	 public void method4() throws Throwable {
		 Driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
		 text1 = Driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).getText();
		  System.out.println(text1);
		  File f = new File("C:\\Users\\lenovo\\eclipse-workspace\\FrameWork.Junit\\src\\test\\resources\\ExcelWrite3.xlsx");
			Workbook W = new XSSFWorkbook();
			Sheet s = W.createSheet("Excel");
			Row r = s.createRow(0);
			Cell c = r.createCell(0);
			c.setCellValue(text1);
			
			FileOutputStream f1 = new FileOutputStream(f);
			W.write(f1);
	 }
	 @Test
	 public void method5() throws Throwable {
		 TakesScreenshot tk = (TakesScreenshot)Driver;
		 File filetype = tk.getScreenshotAs(OutputType.FILE);
		 File location = new File("C:\\Users\\lenovo\\eclipse-workspace\\FrameWork.Junit\\src\\library\\flipkart");
		 FileUtils.copyFile(filetype,location);	 
		 if(text.equals(text1)) {
			 System.out.println("pass");
		 }else {
			 System.out.println("fail");
		 }
	 }
     
}
