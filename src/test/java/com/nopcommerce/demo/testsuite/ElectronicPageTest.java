package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.CellPhonesPage;
import com.nopcommerce.demo.pages.ElectronicsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.NokiaLumiaPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class ElectronicPageTest extends BaseTest {
    ElectronicsPage electronicsPage;
    HomePage homePage;
    NokiaLumiaPage nokiaLumiaPage;
    CellPhonesPage cellPhonesPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        electronicsPage = new ElectronicsPage();
        nokiaLumiaPage = new NokiaLumiaPage();
        cellPhonesPage = new CellPhonesPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        homePage.clickOnElectronicsr();
        electronicsPage.mouseHoverOnCellPhone();
        electronicsPage.verifytextCellPhones();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        homePage.clickOnElectronicsr();
        electronicsPage.clickonCellPhonesoptin();
        Thread.sleep(1000);
        Assert.assertEquals(cellPhonesPage.getVerifyCellPhones(), "Cell phones");
        Thread.sleep(1000);
        cellPhonesPage.clickListView();
        Thread.sleep(2000);
        cellPhonesPage.clickOnNokiaLumia();
        Thread.sleep(2000);
        Thread.sleep(1000);
        nokiaLumiaPage.sendChangeQuantity2("2");
        nokiaLumiaPage.clickAddToCart();
        Thread.sleep(1000);
        Assert.assertEquals(nokiaLumiaPage.getVerifyProductAdded(), "The product has been added to your shopping cart");
        nokiaLumiaPage.clickCloseAlert();
        Thread.sleep(1000);
        nokiaLumiaPage.clickShoppingCart();
        Assert.assertEquals(electronicsPage.verifyShoppingcartText(), "Shopping cart", "text verified");
        Assert.assertEquals(electronicsPage.verifyPriceText(), "$698.00", "text verified");
        electronicsPage.clickOnAgreeTermsandServicesr();
        electronicsPage.clickOnChekout();
        Assert.assertEquals(electronicsPage.verifyWelcomeSignIn(), "Welcome, Please Sign In!", "text verified");
        electronicsPage.clickOnRegister();
        Assert.assertEquals(electronicsPage.verifyRegisterText(), "Register", "text verified");
        electronicsPage.sentTextToFirstName("pradip");
        electronicsPage.sentTextToLastName("kakadiya");
        electronicsPage.sentTextToEmailId("pradip143@gmail.com");
        electronicsPage.sentTextToPassword("Pdd123456");
        electronicsPage.sentTextToconfirmPassword("Pdd123456");
        electronicsPage.clickonRegisterButton1();
        electronicsPage.verifytextyourRegistrationcompleted();
        electronicsPage.clickonContinueButton1();
        electronicsPage.clickonCheckBoxIagree();
        electronicsPage.clickonChekoutButton2();
        electronicsPage.enterCountryName("India");
        electronicsPage.enterCityName("surat");
        electronicsPage.enterResidanceAddress("111 xyz soc");
        electronicsPage.enterZipcodeofArea("395010");
        electronicsPage.enterPhoneNumber("07452541254");
        electronicsPage.clickONContinue3();
        electronicsPage.clickOn2ndDayButton();
        electronicsPage.clickONContinue4();
        electronicsPage.clickOnPaymentMethodField();
        electronicsPage.clickOnMethodCreditCard();
        electronicsPage.selectVisa("Master card");
        Thread.sleep(1000);
        electronicsPage.enterCardHolderNameNokia("prime Testing");
        electronicsPage.enterCardNumberNokia("4111111111111111");
        electronicsPage.enterExpiryMonthNokia("11");
        electronicsPage.enterExpiryYearNokia("2025");
        electronicsPage.enterCardCodeNokia("9132");
        Thread.sleep(1000);
        electronicsPage.clickOnContinueCheckoutNokia();
        Assert.assertEquals(electronicsPage.verif2ndDayAirMethod(), "Shipping Method:", "text verified");
        electronicsPage.clickOnConfirmButton2();
        Assert.assertEquals(electronicsPage.verifThankYouText(), "Thank you", "text verified");
        Thread.sleep(1000);
        Assert.assertEquals(electronicsPage.verifYourOrderSucessfullyPlaced(), "Your order has been successfully processed!", "text verified");
        electronicsPage.clickOnContinueButton5();
        Thread.sleep(1000);
        Assert.assertEquals(electronicsPage.verifWelcomeToOurStorePage(), "Welcome to our store", "text verified");
        electronicsPage.clickOnLogOutLink2();
        Assert.assertEquals(electronicsPage.getUrl(), "https://demo.nopcommerce.com/");


    }
}



