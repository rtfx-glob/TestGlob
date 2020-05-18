package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.automation.techassessment.ui.pages.locators.DashboardLocators;
import com.automation.techassessment.ui.util.DashboardType;
import com.slickqa.webdriver.FindBy;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DashboardPage {

  public final String PRODUCT_BACKPACK = "Sauce Labs Backpack";

  public final String PRODUCT_BACK_LIGHT = "Sauce Labs Bike Light";

  public final String PRODUCT_BOTL_TSHIRT = "Sauce Labs Bolt T-Shirt";

  public final String PRODUCT_FLEECE_JACKET = "Sauce Labs Fleece Jacket";

  public final String PRODUCT_ONESIE = "Sauce Labs Onesie";

  public final String PRODUCT_RED_TSHIRT = "Test.allTheThings() T-Shirt (Red)";

  public static final int WAITING_TIME = 10;

  private final Logger logger = LogManager.getLogger(this.getClass());

  private DashboardLocators dashboard = new DashboardLocators();

  private WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();

  private PageElement btnProductContainer = new PageElement("Product container", FindBy.id("inventory_container"));

  private PageElement btnProductBikeLight = new PageElement("Product container", dashboard.btnSpecificProduct(DashboardType.BIKE_LIGHT));

  private PageElement btnProductOnesie = new PageElement(dashboard.btnSpecificProduct(DashboardType.ONESIE));

  private PageElement btnProductBackpack = new PageElement(dashboard.btnSpecificProduct(DashboardType.BACKPACK));

  private PageElement btnProductFleeceJacket = new PageElement(dashboard.btnSpecificProduct(DashboardType.FLEECE_JACKET));

  private PageElement btnProductBolt = new PageElement(dashboard.btnSpecificProduct(DashboardType.BOLT));

  private PageElement btnProductTestShirtRed = new PageElement(dashboard.btnSpecificProduct(DashboardType.T_SHIRT_RED));

  private PageElement imageProduct1 = new PageElement(dashboard.productsOnDashboard(1));

  private PageElement imageProduct2 = new PageElement(dashboard.productsOnDashboard(2));

  private PageElement imageProduct3 = new PageElement(dashboard.productsOnDashboard(3));

  private PageElement imageProduct4 = new PageElement(dashboard.productsOnDashboard(4));

  private PageElement imageProduct5 = new PageElement(dashboard.productsOnDashboard(5));

  private PageElement imageProduct6 = new PageElement(dashboard.productsOnDashboard(6));

  private PageElement titleProducts = new PageElement(dashboard.lblProducts());

  private PageElement getBackpackProductName = new PageElement(dashboard.getSpecificProductName(DashboardType.BACKPACK));

  private PageElement getBikeLightProductName = new PageElement(dashboard.getSpecificProductName(DashboardType.BIKE_LIGHT));

  private PageElement getBoltTShitProductName = new PageElement(dashboard.getSpecificProductName(DashboardType.BOLT));

  private PageElement getFleeceProductName = new PageElement(dashboard.getSpecificProductName(DashboardType.FLEECE_JACKET));

  private PageElement getOnesieProductName = new PageElement(dashboard.getSpecificProductName(DashboardType.ONESIE));

  private PageElement getTshirtTestProductName = new PageElement(dashboard.getSpecificProductName(DashboardType.T_SHIRT_RED));

  private PageElement btnShoppingCart = new PageElement(dashboard.btnShoppingCart());



  public boolean waitForPageIsLoaded(String title) {

    boolean image1 = webDriverWrapper.isVisible(imageProduct1, WAITING_TIME);
    boolean image2 = webDriverWrapper.isVisible(imageProduct2, WAITING_TIME);
    boolean image3 = webDriverWrapper.isVisible(imageProduct3, WAITING_TIME);
    boolean image4 = webDriverWrapper.isVisible(imageProduct4, WAITING_TIME);
    boolean image5 = webDriverWrapper.isVisible(imageProduct5, WAITING_TIME);
    boolean image6 = webDriverWrapper.isVisible(imageProduct6, WAITING_TIME);

    boolean titlePresent;
    if (title == null) {
      titlePresent = webDriverWrapper.isVisible(titleProducts);
    } else {
      titlePresent = webDriverWrapper.isVisible(titleProducts)
          && webDriverWrapper.getText(titleProducts).toLowerCase().contains(title.toLowerCase());
    }

    return image1 && image2 && image3 && image4
        && image5 && image6 && titlePresent;

  }

  public boolean productContainerIsVisible() {

    return UIThreadManager.getBrowser().exists(btnProductContainer);
  }

  public boolean addProductToShoppingCart(DashboardType product) {

    boolean elementClicked = false;

    switch (product) {
      case BACKPACK:
        try {
          webDriverWrapper.click(btnProductBackpack, WAITING_TIME);
          elementClicked = true;
        } catch (Exception e) {
          elementClicked = false;
        }
        break;
      case BIKE_LIGHT:
        try {
          webDriverWrapper.click(btnProductBikeLight, WAITING_TIME);
          elementClicked = true;
        } catch (Exception e) {
          elementClicked = false;
        }
        break;
      case BOLT:
        try {
          webDriverWrapper.click(btnProductBolt, WAITING_TIME);
          elementClicked = true;
        } catch (Exception e) {
          elementClicked = false;
        }
        break;
      case FLEECE_JACKET:
        try {
          webDriverWrapper.click(btnProductFleeceJacket, WAITING_TIME);
          elementClicked = true;
        } catch (Exception e) {
          elementClicked = false;
        }
        break;

      case ONESIE:
        try {
          webDriverWrapper.click(btnProductOnesie, WAITING_TIME);
          elementClicked = true;
        } catch (Exception e) {
          elementClicked = false;
        }
        break;
      case T_SHIRT_RED:
        try {
          webDriverWrapper.click(btnProductTestShirtRed, WAITING_TIME);
          elementClicked = true;
        } catch (Exception e) {
          elementClicked = false;
        }
        break;
    }
    return elementClicked;
  }

  
  public String getProductToShoppingCartName(DashboardType product) {

    String productName = null;

    switch (product) {
      case BACKPACK:
        productName = webDriverWrapper.getText(getBackpackProductName, WAITING_TIME);
        break;

      case BIKE_LIGHT:
        productName = webDriverWrapper.getText(getBikeLightProductName, WAITING_TIME);
        break;

      case BOLT:
        productName = webDriverWrapper.getText(getBoltTShitProductName, WAITING_TIME);
        break;

      case FLEECE_JACKET:
        productName = webDriverWrapper.getText(getFleeceProductName, WAITING_TIME);
        break;

      case ONESIE:
        productName = webDriverWrapper.getText(getOnesieProductName, WAITING_TIME);
        break;

      case T_SHIRT_RED:
        productName = webDriverWrapper.getText(getTshirtTestProductName, WAITING_TIME);
        break;
    }
    return productName;
  }

  public boolean clickShoppingCart() {
    try {
      webDriverWrapper.click(btnShoppingCart, WAITING_TIME);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}

