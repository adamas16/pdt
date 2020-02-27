import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{

    @Test
    public void testContactCreation() throws Exception {
        autoLogin("admin", "secret");
        initContactCreation();
        fillContactForm("Dmitriy", "Sergeevich", "Romanov", "arrnel", "random title", "Russia", "+7(658)4853568", "random@mail.org", "4", "July", "1954");
        submitContactCreation();
        clickLogo();
        logout();
    }

}

