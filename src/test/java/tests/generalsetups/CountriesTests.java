package tests.generalsetups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.generalsetups.CountriesPage;
import tests.BaseTest;

public class CountriesTests extends BaseTest {


    public CountriesPage countriesPage;

    private static final Logger logger = LoggerFactory.getLogger(CountriesTests.class);

    @BeforeMethod
    public void initializePage() {

        countriesPage = new CountriesPage(webDriver);

    }

    @Test
    public void setupCountryTest() {

        logger.info("Creating the country started.............");
        countriesPage.createCountry();
        logger.info("Country successfully created!!!");

        logger.info("Created country approval process started.........");
        countriesPage.approvePendingCountry();
        logger.info("Created country has been successfully approved!");

        logger.info("Viewing the created country.............");
        countriesPage.viewCreatedCountry();
        logger.info("Created country exists in the database!");

        logger.info("Updating the country's numeric code........");
        countriesPage.updateCountry();
        logger.info("Updated the country's numeric code successfully!");

        logger.info("Deleting operation process for the country initiated......");
        countriesPage.deleteCountry();
        logger.info("Country successfully deleted !!!");

    }



}