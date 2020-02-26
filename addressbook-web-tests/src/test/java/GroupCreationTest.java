import org.testng.annotations.Test;


public class GroupCreationTest extends TestBase{

    @Test
    public void testGroupCreationTests() throws Exception {
        autoLogin("admin", "secret");
        gotoGroupPage();
        initGroupCreation();
        fillGroupForm("test1", "test2", "test3");
        submitGroupCreation();
        returnToGroupPage();
        logout();
    }


}
