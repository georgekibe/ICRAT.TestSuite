package tests.generalsetups;


import org.testng.annotations.BeforeTest;
import pages.generalsetups.CurrenciesPage;
import tests.BaseTest;

import java.lang.ref.PhantomReference;

public class CurrenciesTests extends BaseTest {

    CurrenciesPage currenciesPage;


    @BeforeTest
    public void initializing ()
    {
        currenciesPage = new CurrenciesPage(webDriver);
    }





}
