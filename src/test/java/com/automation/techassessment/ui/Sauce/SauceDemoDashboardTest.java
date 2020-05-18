package com.automation.techassessment.ui.Sauce;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.automation.techassessment.ui.pages.sauce.SauceDemo;
import com.automation.techassessment.ui.util.DashboardType;

public class SauceDemoDashboardTest extends BaseUITest {

  private static final String USERNAME = "standard_user";

  private static final String PASSWORD = "secret_sauce";

  public static final String PRODUCTS = "Products";

  private SoftAssert softAssert = new SoftAssert();

  @BeforeMethod
  public void loginUser() {
    SauceDemo.Login.login(USERNAME, PASSWORD);
    softAssert.assertTrue(SauceDemo.Dashboard.waitForPageIsLoaded(PRODUCTS),"page was not loaded properly");
  }
  
  @Test(description= "Add two items to shopping cart and validate if they were added successfully")
  public void addItemsToShoppingCard() {
    softAssert.assertTrue(SauceDemo.Dashboard.addProductToShoppingCart(DashboardType.ONESIE), "Element was not clicked");
    softAssert.assertTrue(SauceDemo.Dashboard.addProductToShoppingCart(DashboardType.BIKE_LIGHT), "Element was not clicked");
    String onesieProductName = SauceDemo.Dashboard.getProductToShoppingCartName(DashboardType.ONESIE);
    String bikeLightProductName = SauceDemo.Dashboard.getProductToShoppingCartName(DashboardType.BIKE_LIGHT);
    softAssert.assertTrue(SauceDemo.Dashboard.clickShoppingCart(), "Not able to click the element");
    softAssert.assertTrue(SauceDemo.ShoppingCart.waitForPageIsLoaded(DashboardType.ONESIE), "page was not loaded successfully");
    String productOneOnShoppingCart = SauceDemo.ShoppingCart.getProductToShoppingCartName(DashboardType.ONESIE);
    String productSecondOnShoppingCart = SauceDemo.ShoppingCart.getProductToShoppingCartName(DashboardType.BIKE_LIGHT);
    softAssert.assertEquals(onesieProductName, productOneOnShoppingCart,"Element name is not matching");
    softAssert.assertEquals(bikeLightProductName, productSecondOnShoppingCart,"Element name is not matching");
  }
}
