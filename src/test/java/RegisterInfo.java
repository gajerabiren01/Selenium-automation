
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.text.SimpleDateFormat;
import java.time.Duration;

public class RegisterInfo {

    protected static WebDriver driver;



    public static String timeStamp(){
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        return timeStamp;
    }


    public static void clickOnElement(By by) {

        driver.findElement(by).click();

    }

    public static void typeText(By by, String name  ) {
    driver.findElement(by).sendKeys(name);
    }

    public static  String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

    public static void waitForClickable(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void waitForElementToDisappear(By by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf((WebElement) by));
    }

    public static void urlToBe(String by, int time) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(by));
    }

    public static void openBrowser() {

        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
    }

    public static void closeBrowser() {

        driver.close();  //closes the currently focused window/
    }




    public static void main(String[] args) {

        openBrowser();

        clickOnElement(By.className("ico-register"));

        waitForClickable(By.id("register-button"),10);

        typeText(By.id("FirstName"),"FirstName");
        typeText(By.id("LastName"),"Patel");



        Select selectDay = new Select(driver.findElement(By.name(("DateOfBirthDay"))));
        selectDay.selectByVisibleText("15");

        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByIndex(5);

       Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
       selectYear.selectByVisibleText("1995");



        typeText(By.id("Email"),"test"+timeStamp()+"@gmail.com");
        typeText(By.id("Company"),"Hello");
        typeText(By.name("Password"),"jacksmith@1278");
        typeText(By.id("ConfirmPassword"),"jacksmith@1278");
        clickOnElement(By.name("register-button"));
        System.out.println(getTextFromElement(By.className("result")));
        closeBrowser();




//        driver.findElement(By.id("Email")).sendKeys("test"+timeStamp()+"@gmail.com");
        //locator - by id to find company field and type user detail/

//                driver.findElement(By.id("Company")).sendKeys("Hello");
        //locator - by name to find password field and type password/
//        driver.findElement(By.name("Password")).sendKeys("jacksmith@1278");
        //locator - by id to find confirm password field and type confirm password/
//        driver.findElement(By.id("ConfirmPassword")).sendKeys("jacksmith@1278");

        //locator - by name to find register button and click on it/


//


    }


}
