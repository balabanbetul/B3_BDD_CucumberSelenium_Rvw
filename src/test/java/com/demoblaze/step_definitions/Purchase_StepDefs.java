package com.demoblaze.step_definitions;

import com.demoblaze.Pages.CartPage;
import com.demoblaze.Pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Purchase_StepDefs {

    ProductPage productPage= new ProductPage();
    CartPage cartPage=new CartPage();

    @When("the user adds {string} from {string}")
    public void the_user_adds_from(String product, String category) {
  productPage.addProduct_Method(category,product);
    }

    @When("the user removes {string} from cart")
    public void the_user_removes_from_cart(String product) {
        cartPage.removeToCart_method(product);

    }

    @When("the user places order abd captures and log amount")
    public void the_user_places_order_abd_captures_and_log_amount() {

        cartPage.finishPurchase_method();

    }

    @Then("the user verifies purchase amount equals {int}")
    public void the_user_verifies_purchase_amount_equals(int expectedAmount) {
        cartPage.verifyAmount_Method((expectedAmount));

    }




}
