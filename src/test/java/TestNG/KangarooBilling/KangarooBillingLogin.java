package TestNG.KangarooBilling;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class KangarooBillingLogin {
    //Global Variable Section
    //Declare global variable - null driver as well as object
    String BaseURL ="http://192.168.1.50:85/Admin";
    public ChromeDriver driver;

    String expectedResult;
    String actualResult;
    WebDriverWait wait;



    public static String extractedText;

    //in particular class before execute atleast one testcase,if we need to do something,if we need to do any preparation,we need to put that inside the
    //BeforeTest annotation-common things we can put it here
    @BeforeTest
    public void BeforeTestMethod(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BaseURL);
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.sessionStorage.clear(); window.localStorage.clear();");


    }
    //When user enter valid user name & Password, User can Login to the System
    @Test(priority = 1)
    public void KangarooBillingLogin(){
        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement UserName_txt = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement Password_txt=driver.findElement(By.xpath("//*[@id=\"password\"]"));
        WebElement Login_btn = driver.findElement(By.xpath("/html/body/app-root/app-login1/div[1]/div/div/div/div/div/form/div[6]/div[2]/input"));


        //Inputs the values in each and every input fields
        UserName_txt.sendKeys("kangaroobilling");
        Password_txt.sendKeys("kangaroo");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Login_btn.click();

/*
        expectedResult="New Call Center";
        actualResult=driver.getTitle();

        if (actualResult.equals(expectedResult)){
            System.out.println("TC001:Pass");
            System.out.println("Verify when user login to the system, User navigate to Home Page");
        }else {
            System.out.println("TC001:Fail");
        }
*/
    }

}
