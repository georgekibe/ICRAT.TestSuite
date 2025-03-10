package tests.generalsetups;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.generalsetups.CountriesPage;
import tests.BaseTest;

public class CountriesTests extends BaseTest {


    CountriesPage countriesPage;

    @BeforeMethod
    public void initializePage() {

        countriesPage = new CountriesPage(webDriver);

    }

    @Test
    public void createCountryTest() {
        countriesPage.createCountry();
    }

}
