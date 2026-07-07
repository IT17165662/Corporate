package TestNG.KangarooBilling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddOrganization {

    //Global Variable Section
    //Declare global variable - null driver as well as object
    String BaseURL ="http://192.168.1.50:85/Admin";
    public ChromeDriver driver;



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
    //Test case 1:- Verify user able to login to the system
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

    }


    //Test case 2 :- Verify when user click 'ADD ORGANIZATION' , User naviage to add orgaization Page
    @Test(priority = 2)
    public void ClickAddOrganization(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement AddOrgbtn = driver.findElement(By.xpath("//*[@id=\"cont\"]/form/div/div[5]/button"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AddOrgbtn.click();

    }



    //Test case 3 :- Verify user abe to select the 'Organization Type' from the drop down
    @Test(priority = 3,enabled = true)
    public void SelectOrganizationType() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement ClickOrgType = driver.findElement(By.xpath("//*[@id=\"bookingType\"]"));
        WebElement VoucherType  = driver.findElement(By.xpath("//*[@id=\"bookingType\"]/option[1]"));
        WebElement CorpType     = driver.findElement(By.xpath("//*[@id=\"bookingType\"]/option[2]"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ClickOrgType.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CorpType.click();
        Thread.sleep(10000);

    }

    //Test case 4 :- Verify user able to generate customer code
    @Test(priority = 4,enabled = true)
    public void GenerateCustomerCode() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement CustomerCode = driver.findElement(By.xpath("//*[@id=\"customerCode\"]"));
        WebElement Generatebtn  = driver.findElement(By.xpath("//*[@id=\"basic-addon2\"]/a"));


        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CustomerCode.sendKeys("5");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Generatebtn.click();

        Thread.sleep(10000);

    }

    //Test case 5 :- Verify User able to enter Customer name
    @Test(priority = 5,enabled = true)
    public void EnterCustomerName(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement CustomerName = driver.findElement(By.xpath("//*[@id=\"cus_name\"]"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CustomerName.sendKeys("Test");

    }

    //Test case 6 :- Verify User able to enter App Display name
    @Test(priority = 6,enabled = true)
    public void EnterAppDisplayName(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement AppDisplayName = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[3]/div[4]/input"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AppDisplayName.sendKeys("Test App");

    }

    //Test case 7 :- Verify User able to enter Address
    @Test(priority = 7,enabled = true)
    public void EnterAddress(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement Address = driver.findElement(By.xpath("//*[@id=\"address\"]"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Address.sendKeys("Test Road,");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        Address.sendKeys("Colombo");

    }

    //Test case 8 :- Verify user able to select the Organization Categories
    @Test(priority = 8,enabled = true)
    public void SelectOrgCat(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement OrgCatDrop = driver.findElement(By.xpath("//*[@id=\"organizationCategory\"]"));
        WebElement FoodOpt = driver.findElement(By.xpath("//*[@id=\"organizationCategory\"]/option[1]"));
        WebElement TransportOpt = driver.findElement(By.xpath("//*[@id=\"organizationCategory\"]/option[2]"));

        OrgCatDrop.click();
        TransportOpt.click();

    }

    //Test case 9 :- Verify user able to select the Marketing Rep
    @Test(priority =9,enabled = true)
    public void SelectMarketingRep(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement ClickMarketingRepDropdown = driver.findElement(By.xpath("//*[@id=\"marketingRep\"]"));

        ClickMarketingRepDropdown.click();

        WebElement MarketingRep = driver.findElement(By.xpath("//*[@id=\"marketingRep\"]/option[49]"));

        //Scroll until the options is visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",MarketingRep);

        //Then click
        MarketingRep.click();

    }

    //Test case 10 :- Verify user able to select the Type
    @Test(priority = 10,enabled = true)
    public void SelectType(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement TypeDropdown = driver.findElement(By.xpath("//*[@id=\"orgType\"]"));
        WebElement BusinessOpt = driver.findElement(By.xpath("//*[@id=\"orgType\"]/option[1]"));
        WebElement IndividualOpt = driver.findElement(By.xpath("//*[@id=\"orgType\"]/option[2]"));

        TypeDropdown.click();
        BusinessOpt.click();

    }

    //Test case 11 :- Verify user able to enter superadmin detail
    @Test(priority = 11,enabled = true)
    public void SuperAdmindetail(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement FullName = driver.findElement(By.xpath("//*[@id=\"cusFullName\"]"));
        WebElement Email = driver.findElement(By.xpath("//*[@id=\"adminEmail\"]"));
        WebElement ContactNo = driver.findElement(By.xpath("//*[@id=\"cusMobileNumber\"]"));
        WebElement Telephone = driver.findElement(By.xpath("//*[@id=\"cusLandNumber\"]"));

        FullName.sendKeys("Test Auto");
        Email.sendKeys("revathy@2588588.com");

    }

    //Test case 13 :- Verify user able to select invoicing method
    @Test(priority = 13,enabled = true)
    public void InvoicingMethod(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement InvocingMethodDropdown = driver.findElement(By.xpath("//*[@id=\"invoicingMethod\"]"));
        WebElement OrganizationOpt = driver.findElement(By.xpath("//*[@id=\"invoicingMethod\"]/option[1]"));
        WebElement DepartmentOpt = driver.findElement(By.xpath("//*[@id=\"invoicingMethod\"]/option[2]"));
        WebElement DepartmentandBulkOpt = driver.findElement(By.xpath("//*[@id=\"invoicingMethod\"]/option[3]"));

        InvocingMethodDropdown.click();
        OrganizationOpt.click();

    }

    //Test case 14 :- Verify user able to enter BRC/Fax
    @Test(priority = 14,enabled = true)
    public void BrcFax(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement BRCno = driver.findElement(By.xpath("//*[@id=\"id_no\"]"));
        WebElement Fax = driver.findElement(By.xpath("//*[@id=\"fax\"]"));

        BRCno.sendKeys("45585565");
        Fax.sendKeys("4454888555");

    }

    //Test case 17 :- Verify user able to select Approved Categories
    @Test(priority = 17,enabled = true)
    public void ApprovedCat() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement ApprovedCategries = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/label[1]"));

        //Scroll until the options is visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",ApprovedCategries);


        //Identify the element by id/xpath/class / any locator in corporate Page
        //WebElement Expo = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[2]"));
        WebElement Budget = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[3]"));
        //WebElement City = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[4]"));
        WebElement Car = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[5]"));
        //WebElement Semi = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[6]"));
        //WebElement Minivan = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[7]"));
        WebElement Van = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[8]"));
        //WebElement BuddyVan = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[7]/div[1]/div/div[9]"));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Budget.click();
        Car.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Van.click();


    }


























    //Test case 15 :- Verify when user select Corporate as Org type, User able to On/Off Voucher
    @Test(priority =15 ,enabled = true)
    public void OnOffVoucherAllowBookingsSwitch(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //WebElement CustomerRegistration = driver.findElement(By.xpath("/html/body/app-root/app-menu/mat-drawer-container/mat-drawer-content/app-customer-reg/div/div/div/form/div[1]/div/h1[1]"));

        //Scroll until the options is visible
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",CustomerRegistration);

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement AllowVoucherSwitch = driver.findElement(By.xpath("//*[@id=\"isVoucherBookingAllowed-button\"]"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AllowVoucherSwitch.click();

    }

    //Test case 16 :- Verify user able to turn on/off callcenter , When call center - on User able to view the corporate methods in Payment dropdown
    @Test(priority = 16,enabled = true)
    public void OnOffCallcenterSwitch(){

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Identify the element by id/xpath/class / any locator in corporate Page
        WebElement CallcenterSwitch = driver.findElement(By.xpath("//*[@id=\"isCallCenterOrderAllowed-button\"]"));

        //Inputs the values in each and every input fields
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CallcenterSwitch.click();

    }

}
