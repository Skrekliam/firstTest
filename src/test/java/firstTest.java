import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
 import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class firstTest {
    WebDriver driver;
    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver","C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


    }
  /*
    @Test

    public void test1(){
        driver.get("https://www.phptravels.net/home");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//a[@href='#hotels']")).click();
        driver.findElement(By.xpath("//div[@id='s2id_autogen1']/a")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']/div/input")).sendKeys("123");//
        driver.findElement(By.xpath("//label[contains(text(),'Check in')]/../div[@class='form-icon-left']")).click();
        driver.findElement(By.xpath("//input[@id='checkin']")).sendKeys("asdsadasd");
        driver.findElement(By.xpath("//label[contains(text(),'Check out')]/../div[@class='form-icon-left']']")).click();
        driver.findElement(By.xpath("//input[@id='checkout']")).sendKeys("ddddddd");

        // driver.findElement(By.xpath("//form[@name='HOTELS']//button[@type ='submit']")).click();//.sendKeys("New York, United States");

    }*/

    @Test
    public void test2(){

        driver.get("https://www.phptravels.net/home");

        String firstname = "John";
        String lastname = "Tacker";
        driver.findElement(By.xpath("//a[@id = 'dropdownCurrency']/i/..")).click();
        driver.findElement(By.xpath("//a[text() = 'Sign Up']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("3640231222");
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("tacker@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tacker123");
        driver.findElement(By.xpath("//input[@name='confirmpassword']")).sendKeys("tacker123");
        driver.findElement(By.xpath("//button[contains(@class ,'signupbtn')]")).click();

        String actual = driver.findElement(By.cssSelector(".text-align-left")).getText();
                Assert.assertEquals(actual, "Hi, "+firstname+" "+ lastname);
    }
    @Test
    public void test3(){
        driver.get("https://phptravels.net/admin");
        driver.findElement(By.xpath("//form[contains(@class,'form-signin')]//input[@name='email']")).sendKeys("admin@phptravels.com");
        driver.findElement(By.xpath("//form[contains(@class,'form-signin')]//input[@name='password']")).sendKeys("demoadmin");
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        driver.findElement(By.xpath("//a[@href='#ACCOUNTS']")).click();
        driver.findElement(By.xpath("//a[@href='#ACCOUNTS']/..//a[text() = 'Customers']")).click();
        driver.findElement(By.xpath("//a[text() = 'tacker@gmail.com']//../..//a[@title='DELETE']")).click();
        Alert confirmationAlert = driver.switchTo().alert();
        confirmationAlert.accept();
        driver.findElement(By.xpath("//a[@id = 'dropdownCurrency']/i/..")).click();
        driver.findElement(By.xpath("//a[text() = 'Login']")).click();
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tacker@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tacker123");
        driver.findElement(By.xpath("//button[contains(@class , 'loginbtn')]")).click();
        String actual = driver.findElement(By.xpath("//div[@class = 'resultlogin']/div")).getText();
        Assert.assertEquals(actual, "Invalid Email or Password");
    }
    @AfterClass
    public void close(){
        driver.quit();
    }
}
