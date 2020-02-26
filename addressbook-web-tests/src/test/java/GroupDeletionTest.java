import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupDeletionTest extends TestBase{

    @Test
    public void testGroupDeletion() throws Exception {
        autoLogin("admin", "secret");
        gotoGroupPage();
        selectGroup();
        submitGroupDeletion();
        returnToGroupPage();
        logout();
    }


}
