package com.automation.techassessment.ui.pages.locators;

import org.openqa.selenium.By;
import com.automation.techassessment.ui.util.DashboardType;

public class ShoppingCartLocators {

  public By getSpecificProductName(DashboardType productName) {
    String product = String.format("//a//div[text()='%s']", productName);
    return By.xpath(product);
  }

  public By btnContinueShopping() {
    return By.xpath("//div//a[text()='Continue Shopping']");
  }
  
  public By btnCheckout() {
    return By.xpath("//div//a[text()='CHECKOUT']");
  }
}
