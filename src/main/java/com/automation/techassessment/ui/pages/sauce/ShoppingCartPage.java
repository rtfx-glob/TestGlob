package com.automation.techassessment.ui.pages.sauce;

import com.automation.techassessment.ui.lib.UIThreadManager;
import com.automation.techassessment.ui.pages.locators.ShoppingCartLocators;
import com.automation.techassessment.ui.util.DashboardType;
import com.slickqa.webdriver.PageElement;
import com.slickqa.webdriver.WebDriverWrapper;

public class ShoppingCartPage {

  public static final int WAITING_TIME = 10;

  private ShoppingCartLocators shoppingCart = new ShoppingCartLocators();

  private PageElement btnCheckout = new PageElement(shoppingCart.btnCheckout());

  private PageElement btnContinueSHopping = new PageElement(shoppingCart.btnContinueShopping());

  private WebDriverWrapper webDriverWrapper = UIThreadManager.getBrowser();

  private PageElement getBackpackProductName = new PageElement(shoppingCart.getSpecificProductName(DashboardType.BACKPACK));

  private PageElement getBikeLightProductName = new PageElement(shoppingCart.getSpecificProductName(DashboardType.BIKE_LIGHT));

  private PageElement getBoltTShitProductName = new PageElement(shoppingCart.getSpecificProductName(DashboardType.BOLT));

  private PageElement getFleeceProductName = new PageElement(shoppingCart.getSpecificProductName(DashboardType.FLEECE_JACKET));

  private PageElement getOnesieProductName = new PageElement(shoppingCart.getSpecificProductName(DashboardType.ONESIE));

  private PageElement getTshirtTestProductName = new PageElement(shoppingCart.getSpecificProductName(DashboardType.T_SHIRT_RED));


  public boolean waitForPageIsLoaded(DashboardType productName) {
    PageElement getProductName = new PageElement(shoppingCart.getSpecificProductName(productName));
    boolean pageLoaded = false;
    boolean _btnCheckout;
    boolean _btnContinueShopping;
    try {
      _btnCheckout = webDriverWrapper.isVisible(btnCheckout, WAITING_TIME);
      _btnContinueShopping = webDriverWrapper.isVisible(btnContinueSHopping, WAITING_TIME);
      String _productName = webDriverWrapper.getText(getProductName);
      if(_productName.contains(productName.toString())) {
        pageLoaded = true;
      }else {
        pageLoaded = false;
      }
    } catch (Exception e) {
      return pageLoaded = false;
    }
    return _btnCheckout && _btnContinueShopping && pageLoaded;
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
}
