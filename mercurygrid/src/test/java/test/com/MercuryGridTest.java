/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Siraj Siddiqui
 */

@RunWith(value = Parameterized.class)
public class MercuryGridTest {
    static WebDriver driver;
    static String baseUrl, nodeURL;    
    String os;
    String browser;  
    
    // Inject via constructor
    public MercuryGridTest(String os, String browser) {
        this.os = os;
        this.browser = browser;
       }
    
    /*public MercuryGridTest() {
        
    }*/
    
    @BeforeClass
    public static void setUpClass(){
               
    }
    
    @AfterClass
    public static void tearDownClass() {
      
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void mercuryTest() throws InterruptedException, MalformedURLException{
        
         DesiredCapabilities capability = new DesiredCapabilities();
        //browser
        if (browser.equalsIgnoreCase("firefox")) {
            capability = DesiredCapabilities.firefox();
             //driver=new RemoteWebDriver(new URL("http://192.168.0.12:4445/wd/hub"),capability);
             driver = new RemoteWebDriver(new URL("http://192.168.0.12:4441/wd/hub"), capability);
              
        } else if(browser.equalsIgnoreCase("chrome")) {
            capability = DesiredCapabilities.chrome();
            //driver=new RemoteWebDriver(new URL("http://192.168.0.12:4445/wd/hub"), capability);
            driver = new RemoteWebDriver(new URL("http://192.168.0.12:4441/wd/hub"), capability);
        }
        //platform
        if (os.equalsIgnoreCase("windows")) {
            capability.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        } else if (os.equalsIgnoreCase("mac")) {
            capability.setPlatform(org.openqa.selenium.Platform.MAC);
        }

        //driver=new RemoteWebDriver(new URL("http://10.0.0.4:8990/wd/hub"),capability);
        
        driver.get("http://newtours.demoaut.com/");
        try{
            assertEquals("Welcome: Mercury Tours", driver.getTitle()); 
            System.out.println("Webpage Launched");
        }catch(Throwable t){
         System.out.println("Webpage Not Launched");
        }
        driver.findElement(By.linkText("Flights")).click();
        driver.findElement(By.name("userName")).sendKeys("mercury");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.name("login")).click();
       Thread.sleep(2000);
       try{
            assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
            System.out.println("Login Successful");
            }catch(Throwable t){
           System.out.println("Login Not Successful");
        }
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
        Thread.sleep(1000);        
        Select passenger=new Select(driver.findElement(By.name("passCount")));
        passenger.selectByVisibleText("3");
        Select from=new Select(driver.findElement(By.name("fromPort")));
        from.selectByVisibleText("New York");
        Select monthfrom=new Select(driver.findElement(By.name("fromMonth")));
        monthfrom.selectByVisibleText("May");
        Select fromday=new Select(driver.findElement(By.name("fromDay")));
        fromday.selectByVisibleText("8");
        Select to=new Select(driver.findElement(By.name("toPort")));
        to.selectByVisibleText("Sydney");
        Select tomonth=new Select(driver.findElement(By.name("toMonth")));
        tomonth.selectByVisibleText("June");
        Select today=new Select(driver.findElement(By.name("toDay")));
        today.selectByVisibleText("15");
        driver.findElement(By.cssSelector("body > div:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(1) > form:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(9) > td:nth-child(2) > font:nth-child(1) > font:nth-child(2) > input:nth-child(2)")).click();
        Thread.sleep(1000);
        Select selectairlines=new Select(driver.findElement(By.name("airline")));
        selectairlines.selectByVisibleText("Blue Skies Airlines");
        driver.findElement(By.name("findFlights")).click();
        try{
            assertEquals("Select a Flight: Mercury Tours", driver.getTitle());
            System.out.println("Select flight page");
        }catch(Throwable t){
            System.out.println("Select Flight page Not Launched");
        }
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[1]/tbody/tr[5]/td[1]/input")).click();
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table[2]/tbody/tr[9]/td[1]/input")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("reserveFlights")).click();
        try{
            assertEquals("Book a Flight: Mercury Tours", driver.getTitle());
            System.out.println("Book Flights Page");
        }catch(Throwable t){
            System.out.println("Book Flights page not Launched");
        }
        driver.findElement(By.name("passFirst0")).sendKeys("abc");
        driver.findElement(By.name("passLast0")).sendKeys("def");
        Select meal=new Select(driver.findElement(By.name("pass.0.meal")));
        meal.selectByVisibleText("Muslim");
        Select card=new Select(driver.findElement(By.name("creditCard")));
        card.selectByVisibleText("MasterCard");
        driver.findElement(By.name("creditnumber")).sendKeys("3456790393774");
        Select expmn=new Select(driver.findElement(By.name("cc_exp_dt_mn")));
        expmn.selectByVisibleText("07");
        Select expyr=new Select(driver.findElement(By.name("cc_exp_dt_yr")));
        expyr.selectByVisibleText("2010");
        driver.findElement(By.name("billAddress1")).clear();
        driver.findElement(By.name("billAddress1")).sendKeys("1505 Milwaukee Ave");
        Thread.sleep(1000);
        driver.findElement(By.name("billCity")).clear();
        driver.findElement(By.name("billCity")).sendKeys("Libertyville");
        driver.findElement(By.name("billState")).clear();
        driver.findElement(By.name("billState")).sendKeys("IL");
        Select country=new Select(driver.findElement(By.name("billCountry")));
        country.selectByVisibleText("UNITED STATES");
        driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td[2]/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("buyFlights")).click();
        assertEquals("Flight Confirmation: Mercury Tours", driver.getTitle());
        System.out.println("Flight Confirmation Page");
        driver.findElement(By.linkText("SIGN-OFF")).click();
        try{
            assertEquals("Sign-on: Mercury Tours", driver.getTitle());
            System.out.println("Sign On Page");
        }catch(Throwable t){
            System.out.println("Sign on page not Launched");
        }
        driver.findElement(By.linkText("Hotels")).click();
        driver.findElement(By.linkText("Car Rentals")).click(); 
        driver.close();        
    }     
@Parameterized.Parameters(name = "{index}: MercuryGridTest({0},{1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"windows", "chrome"},
            {"windows", "firefox"}});
    
        }
}

