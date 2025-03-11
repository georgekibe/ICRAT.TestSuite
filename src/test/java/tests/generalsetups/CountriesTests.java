package tests.generalsetups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
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

    @Test(priority = 1)
    public void createCountryTest() {

        countriesPage = new CountriesPage(webDriver);

        countriesPage.createCountry();

        logger.info("Country successfully created!!!");

        countriesPage.approvePendingCountry();
        logger.info("Created country has been successfully approved!");

        countriesPage.viewCreatedCountry();
        logger.info("Created country exists in the database!");

    }



}