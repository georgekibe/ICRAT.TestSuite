package tests.generalsetups;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.generalsetups.CountriesPage;
import tests.BaseTest;

public class CountriesTests extends BaseTest {


    CountriesPage countriesPage;

    @BeforeMethod
    public void initializePage() {
        if (countriesPage == null) {
            countriesPage = new CountriesPage(webDriver);
            System.out.println("Here 3");
        }
        System.out.println("Here 4");
    }

    @Test
    public void createCountryTest(){
        countriesPage.createCountry();
    }

}
