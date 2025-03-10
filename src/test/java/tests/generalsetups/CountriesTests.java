package tests.generalsetups;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.generalsetups.CountriesPage;
import tests.BaseTest;

public class CountriesTests extends BaseTest {


    CountriesPage countriesPage;

    @Test
    public void createCountryTest(){
        countriesPage.createCountry();
    }

}
