import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Given("^I am on a main application page$")
    public void getMainPage() {
        driver = new ChromeDriver();
        driver.get("http://mail.ru");
        driver.manage().window().maximize();
    }

    @When("^I login as a correct user$")
    public void login() {
        loginPage = new LoginPage(driver);
        loginPage.enterLogin("shabar.nik@mail.ru");
        loginPage.enterPassword("testing2020");
    }

    @Then("^user name is visible$")
    public void seeLogoutLink() {
        Assert.assertTrue(loginPage.logoutLinkPresents());
    }
}
