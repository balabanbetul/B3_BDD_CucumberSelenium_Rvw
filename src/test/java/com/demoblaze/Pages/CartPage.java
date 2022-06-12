package com.demoblaze.Pages;

import com.demoblaze.Utilities.BrowserUtils;
import com.demoblaze.Utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    @FindBy(xpath = "//a[.='Cart']")
    public WebElement cart_loc;

    @FindBy (xpath = "//button[.='Place Order']")
    public WebElement placeHolder_loc;

    @FindBy (id="name")
    public WebElement name_loc;

    @FindBy (id="country")
    public WebElement country_loc;

    @FindBy (id="city")
    public WebElement city_loc;

    @FindBy (id="card")
    public WebElement creditcard_loc;

    @FindBy (id="month")
    public WebElement month_loc;

    @FindBy (id="year")
    public WebElement year_loc;

    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchase_loc;

    @FindBy (css = ".lead.text-muted ")
    public WebElement confirmation_loc;

    int actualAmount;


    public void removeToCart_method(String product){
        cart_loc.click();
        BrowserUtils.waitFor(2);
        WebElement deleteProduct= Driver.get().findElement(By.xpath("//tbody//tr//td[.='"+product+"']/..//td[.='Delete']/a"));
        deleteProduct.click();
    }

    public void fillForm_method(){
        Faker faker= new Faker();
        BrowserUtils.waitFor(2);
        name_loc.sendKeys(faker.name().fullName());
        BrowserUtils.waitFor(1);
        country_loc.sendKeys(faker.country().name());
        BrowserUtils.waitFor(1);
        city_loc.sendKeys(faker.country().capital());
        BrowserUtils.waitFor(1);
        creditcard_loc.sendKeys(faker.finance().creditCard());
        BrowserUtils.waitFor(1);
        month_loc.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        BrowserUtils.waitFor(1);
        year_loc.sendKeys(String.valueOf(faker.number().numberBetween(2022,2030)));
        BrowserUtils.waitFor(1);

    }

    public  void finishPurchase_method(){
        BrowserUtils.waitFor(1);
        placeHolder_loc.click();
        BrowserUtils.waitFor(3);
        fillForm_method();
        BrowserUtils.waitFor(2);
        purchase_loc.click();
        BrowserUtils.waitFor(2);
        String confirmationNum=confirmation_loc.getText();
        System.out.println(confirmationNum);

        String [] confirmationArray= confirmationNum.split("\n");
        //String array1=confirmationArray[1].split(" ")[1];
        actualAmount=Integer.parseInt(confirmationArray[1].split(" ")[1]);
        System.out.println("amount = " + actualAmount);
    }
    public  void verifyAmount_Method(int expectedAmount){
        Assert.assertEquals(expectedAmount,actualAmount);
    }
}
