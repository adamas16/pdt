import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ContactCreationTest {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testContactCreation() throws Exception {
        autoLogin("admin", "secret");
        initContactCreation();
        fillContactForm("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954");
        submitContactCreation();
        clickLogo();
    }

    private void autoLogin(String user, String password) {
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    private void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    private void fillContactForm(String name, String patronymic, String lastName, String nickName, String title, String country, String phone, String mail, String bDay, String bMonth, String bYear) {
        driver.findElement(By.name("firstname")).click();
        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(name);
        driver.findElement(By.name("middlename")).clear();
        driver.findElement(By.name("middlename")).sendKeys(patronymic);
        driver.findElement(By.name("lastname")).click();
        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("nickname")).click();
        driver.findElement(By.name("nickname")).clear();
        driver.findElement(By.name("nickname")).sendKeys(nickName);

        driver.findElement(By.name("title")).click();
        driver.findElement(By.name("title")).clear();
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("address")).click();
        driver.findElement(By.name("address")).clear();
        driver.findElement(By.name("address")).sendKeys(country);
        driver.findElement(By.name("mobile")).click();
        driver.findElement(By.name("mobile")).clear();
        driver.findElement(By.name("mobile")).sendKeys(phone);

        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(mail);

        driver.findElement(By.name("bday")).click();
        new Select(driver.findElement(By.name("bday"))).selectByVisibleText(bDay);
        driver.findElement(By.name("bday")).click();
        driver.findElement(By.name("bmonth")).click();
        new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(bMonth);
        driver.findElement(By.name("bmonth")).click();
        driver.findElement(By.name("byear")).click();
        driver.findElement(By.name("byear")).clear();
        driver.findElement(By.name("byear")).sendKeys(bYear);
        driver.findElement(By.name("new_group")).click();
    }

    private void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    private void clickLogo() {
        driver.findElement(By.id("logo")).click();
    }

    private void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

}

