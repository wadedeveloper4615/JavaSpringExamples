package com.wade.spring.examples.springcucumber.bagextra;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import org.springframework.beans.factory.annotation.Autowired;

import com.wade.spring.examples.springcucumber.bagcommons.BagHttpClient;

import static org.assertj.core.api.Assertions.assertThat;

public class BagExtraCucumberStepDefinitions {

    @Autowired
    private BagHttpClient bagHttpClient;

    @Given("^the bag is not empty$")
    public void the_bag_is_not_empty() {
        bagHttpClient.put("something");
        assertThat(bagHttpClient.getContents().isEmpty()).isFalse();
    }

    @When("^I empty the bag$")
    public void empty_the_bag() {
        bagHttpClient.clean();
    }
}
