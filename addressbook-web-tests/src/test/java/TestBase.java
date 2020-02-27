import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Step ("Автовход")
    public void autoLogin(String user, String password) {
        driver.get("http://localhost/addressbook/");
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(user);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Step ("Переход в вкладку группы")
    public void gotoGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    @Step ("Нажатие на клавишу создания группы")
    public void initGroupCreation() {
        driver.findElement(By.name("new")).click();
    }

    @Step ("Заполнение формы новой группы")
    public void fillGroupForm(String name, String header, String footer) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(name);
        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys(header);
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(footer);
    }

    @Step ("Подтверждение создания новой группы")
    public void submitGroupCreation() {
        driver.findElement(By.name("submit")).click();
    }

    @Step ("Возврат на страницу групп")
    public void returnToGroupPage() {
        driver.findElement(By.linkText("group page")).click();
    }

    @Step ("Нажатие на создание нового контакта")
    public void initContactCreation() {
        driver.findElement(By.linkText("add new")).click();
    }

    @Step ("Заполнение формы нового контакта")
    public void fillContactForm(String name, String patronymic, String lastName, String nickName, String title, String country, String phone, String mail, String bDay, String bMonth, String bYear) {
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

    @Step ("Подтверждение создания контакта")
    public void submitContactCreation() {
        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    @Step ("Выбор группы")
    public void selectGroup() {
        driver.findElement(By.name("selected[]")).click();
    }

    @Step ("Подтверждение удаления группы")
    public void submitGroupDeletion() {
        driver.findElement(By.name("delete")).click();
    }

    @Step ("Подтверждение удаления контакта")
    public void submitContactDeletion() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value=\"Delete\"]")).click();
        driver.switchTo().alert().accept();
    }

    @Step ("Нажатие на лого")
    public void clickLogo() {
        driver.findElement(By.id("logo")).click();
    }

    @Step ("Выход из учетной записи")
    public void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @Step ("Выбор контакта")
    public void selectContact(){
        driver.findElement(By.xpath("(//input[@name=\"selected[]\"])[1]"));
    }

    @AfterMethod(alwaysRun = true)
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
