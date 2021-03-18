package com.wade.spring.examples.springcucumber.bagcommons;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "junit:build/cucumber-junit.xml", "html:build/cucumber.html"},
        features = "classpath:/"
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)public class CucumberSpringConfiguration {
}
