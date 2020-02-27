import org.testng.annotations.Test;

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
