package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)


public class ComputerPageTest extends BaseTest {
    ComputerPage computerPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyProductArrangeInAlphaBaticalOrder() {
        homePage.clickOnComputer();
        computerPage.clickonDesktop();
        computerPage.sortByPositionZtoA("6");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        homePage.clickOnComputer();
        computerPage.clickonDesktop();
        computerPage.verifyProductsArrangeDescendingOrder();

        computerPage.clickOnAddToCart();
        Thread.sleep(1000);
        Assert.assertEquals(computerPage.verifyBuildyourowncomputerText(), "Build your own computer", "text verified");
        computerPage.selectDualCoreE2200("1");
        computerPage.select8GbFunctionality("5");
        computerPage.selectHddRadioOption();
        computerPage.selectVistaPremiumOption();
        computerPage.clickonMicrosoftOfficeOption();
        Assert.assertEquals(computerPage.verifyPriceText(), "$1,475.00", "text verified");
        computerPage.clickonAddtoCardButton();
        Assert.assertEquals(computerPage.verifyProcductAddedToCart(), "The product has been added to your shopping cart", "text verified");
        computerPage.mouseHoverOnGoToCart();
        Assert.assertEquals(computerPage.verifyMessageShoppingCart(), "Shopping cart", "text verified");
        computerPage.ChangeQuntity("2");
        Assert.assertEquals(computerPage.verifyTotalPriceText(), "$2,950.00", "text verified");
        computerPage.clickOnCheckBoxTick();
        computerPage.clickOnCheckOutButton();
        computerPage.clickOnCheckOutAsGuestButton();
        computerPage.sendTextToFirstName("pradip");
        computerPage.sendTextToLastName("kukadiya");
        computerPage.sendTextToEmailIdField("praidp143@gmail.com");
        computerPage.sendTextToCountryField("United Kingdom");
        computerPage.sendTextToCityField("Delhi");
        computerPage.sendTextToAdressField("54,Ayodhya nagar");
        computerPage.sendTextToZipCodeField("ha25gh");
        computerPage.sendTextToPhoneNumberField("07442525021");
        computerPage.clickOnCountinueButton1();
        computerPage.clickOnNextDayButton();
        computerPage.clickOnCountinueButton2();
        computerPage.clickOnCreditCardRadioButton();
        computerPage.selectcreditCardRadioButton2();
        computerPage.clickOnCreditCardfromTheOption();
        computerPage.selectMasterCardTye();
        computerPage.sendTxtToCrdHolderName("pradip");
        computerPage.sendTxtToCardNumber("6764032004359978");
        computerPage.sendTxtToExpireMonth("11");
        computerPage.sendTxtToExpireYearr("2025");
        computerPage.sendTxtToCardCodeCvv("9132");
        computerPage.clickOnContinue3();
        Assert.assertEquals(computerPage.verifyPaymentMethodCreditCar(), "Payment Method: Credit Card", "text verified");
        Assert.assertEquals(computerPage.verifyShippingMethodText(), "Shipping Method: Next Day Air", "text verified");
        Assert.assertEquals(computerPage.verifyPricetext2(), "$2,950.00", "text verified");
        computerPage.clickOnConfirmButton4();
        Assert.assertEquals(computerPage.verifyThankyouText(), "Thank you", "text verified");
        Assert.assertEquals(computerPage.verifyYourOrderProcced(), "Your order has been successfully processed!", "text verified");
        computerPage.clickonFinalContinue();
        Assert.assertEquals(computerPage.verifyWelcomtoOurStore(), "Welcome to our store", "text verified");

    }


}