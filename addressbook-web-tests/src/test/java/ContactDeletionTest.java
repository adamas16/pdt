import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase{

    @Test
    public void testContactDeletion() throws Exception {
        autoLogin("admin", "secret");
        selectGroup();
        submitContactDeletion();
        logout();
    }

}
