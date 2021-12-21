import Page.BigStapSellersPage;
import Page.BigStapTradePage;
import Page.BigStepHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class BigStepJavaTest extends CommonConditions{

    private BigStapTradePage tradePage;
    private BigStapSellersPage sellersPage;

    private String eMail = "ilyabudnikuttest@mail.ru";
    private String pass = "Bulka2002";
    private String valueTokens = "0.01";
    private String valueBTC = "40000";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        tradePage = new BigStepHomePage(driver)
                .openPage()
                .openLoginWindow()
                .enterEmail(eMail)
                .enterPassword(pass)
                .signIn();
    }

    @Test
    public void firstBigStapTest() throws InterruptedException {
        sellersPage = tradePage.closeMenuButtonOnDisplay()
                .clickRollMenu()
                .clickDemoSlider()
                .closeMenuButtonOnDisplay()
                .clickSellersPageTrans()
                .inputPrices(valueTokens)
                .clickNicePrice()
                .clickAcceptButton();
        Assert.assertTrue(sellersPage.isVisableNotification());
    }

    @Test
    public void secondBigStapTest() throws InterruptedException {
        sellersPage = tradePage.closeMenuButtonOnDisplay()
                .clickRollMenu()
                .clickDemoSlider()
                .closeMenuButtonOnDisplay()
                .clickSellersPageTrans()
                .inputPrices(valueTokens)
                .inputSellersPage(valueBTC)
                .clickAcceptButton();
        Assert.assertTrue(sellersPage.isVisableNotification());
    }

    @AfterMethod(alwaysRun = true)
    public void brClose() {
        driver.quit();
        driver = null;
    }
}
