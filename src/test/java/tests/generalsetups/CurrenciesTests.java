package tests.generalsetups;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.generalsetups.CurrenciesPage;
import tests.BaseTest;

public class CurrenciesTests extends BaseTest {

    public CurrenciesPage currenciesPage;
    private static final Logger logger = LoggerFactory.getLogger(CurrenciesTests.class);

    @BeforeMethod
    public void initializing() {
        currenciesPage = new CurrenciesPage(webDriver);
    }


    @Test
    public void settingCurrencyTest() {
        logger.info("Creating a currency started..........................");
        currenciesPage.creatingCurrency();
        logger.info("A currency entry successfully created !!!");
        logger.info("Approving created currenct initiated.........");
        currenciesPage.approvePenndingCurrencies();
        logger.info("Currency successfully approved !!!!");
        logger.info("Updating the currency entry..........");
        currenciesPage.updateCurrency();
        logger.info("Successfully updated the currency  !!!");
        logger.info("Deletion process initiated for the currency.....");
        currenciesPage.deleteCurrency();
        logger.info("Deletion process successful for the currency created for testing !!!");

    }


}
