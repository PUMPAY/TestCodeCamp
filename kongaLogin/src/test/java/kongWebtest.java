import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class kongWebtest {
    private WebDriver driver;


    @BeforeTest
    public void Setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.konga.com/");

        //TEST 1 (verify that the Url is correct//
        if (driver.getCurrentUrl().contains("https://www.konga.com/")) {
            //then print url is correct//
            System.out.println("the Konga URl is very correct");
        } else
            //print the @selenium URl is wrong"//
            System.out.println("the Konga URl is wrong. Please check for the right URL");
        //maximize page//
        driver.manage().window().maximize();

        // click on the sign-up page//
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(2000);

        //TEST 2.(VERIFY THAT THE USER IS DIRECTED TO THE SIGN-UP PAGE//
        if (driver.getCurrentUrl().contains("https://www.konga.com/account/login?return_url=/")) {
            System.out.println("the sign up page is correct and confirmed correct");
        }else
            System.out.println("the sign up page is wrong.--ATTENTION PLEASE");
    }
    @Test(priority =0)
    public void PositiveSignUpTest() throws InterruptedException {
        //input email on the email field//
        driver.findElement(By.id("username")).sendKeys("ogunbanwo.tolulope@yahoo.com");
        //input password on password field//
        driver.findElement(By.id("password")).sendKeys("to292=");
        //click the signUp key//
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
        //TEST 3- VERIFY THAT USER CAN SIGN UP WITH VALID DETAILS//
        if (driver.getCurrentUrl().contains("https://www.konga.com/")) {
            System.out.println("SUCCESS- the user is able to sign up with VALID DETAILS");
        } else ;
        System.out.println("ATTENTION- user cannot sign up with valid details ");
    }
    @Test(priority = 1)
    public void logout() throws InterruptedException {
        //click on logout//
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/a/span"));
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/div/ul/li[7]/a"));
        Thread.sleep(10000);
        //TEST 4- CONFIRM THAT USER IS DIRECTED TO THE HOME PAGE AFTER LOGGING OUT//
        if(driver.getCurrentUrl().contains("https://www.konga.com/")) {
            System.out.println("user is succesfully directed to the home page after logging out");
        }else;
        System.out.println("user was not directed to the home page after logging out");
    }
    public void ClickSignUpPage() throws InterruptedException {
        // click on the sign-up page//
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(2000);
    }
    @Test (priority =2)
    public void NegativeSignUpTest() throws InterruptedException {
        //input email on the email field//
        driver.findElement(By.id("username")).sendKeys("ogunnwo.tolulope@yahoo.com");
        //input password on password field//
        driver.findElement(By.id("password")).sendKeys("t92=");
        //click the signUp key//
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(10000);
//verify user cannot login with invalid details
        if(driver.getCurrentUrl().contains("https://www.konga.com/account/login?return_url=/")) {
            System.out.println("user cannot login with invalid details");
        }else;
        System.out.println("user logged in with invalid details");
    }
    @AfterTest
    public void closeTheBrowser () {
        //quit the browser//
        driver.quit();//
    }
}



