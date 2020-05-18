package com.automation.techassessment.ui.pages.locators;

import org.openqa.selenium.By;
import com.automation.techassessment.ui.util.DashboardType;
import com.slickqa.webdriver.FindBy;

public class DashboardLocators {

  public By btnSpecificProduct(DashboardType productName) {
    String product = String.format("(//div[text()='%s']/following::button[text()='ADD TO CART'])[1]", productName.toString());
    return FindBy.xpath(product);
  }

  public By getSpecificProductName(DashboardType productName) {
    String product = String.format("//div[text()='%s']", productName.toString());
    return FindBy.xpath(product);
  }

  public By productsOnDashboard(int index) {
    String item =  String.format("(//div//a//img[contains(@class,'inventory_item')])[%s]", index);
    return FindBy.xpath(item);
  }

  public By lblProducts() {
    return FindBy.xpath("//div//div[text()='Products']");
  }

  public By btnShoppingCart() {
    return FindBy.xpath("//*[name()='svg'][contains(@class,'shopping-cart')]");
  }
}
