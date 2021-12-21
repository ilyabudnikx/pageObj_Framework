import Framework.Driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

public class CommonConditions {

    public WebDriver driver;

    @BeforeMethod
    public void setupWebDriver() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void caboomBrowser() {
        DriverSingleton.closeDriver();
        driver = null;
    }
}
