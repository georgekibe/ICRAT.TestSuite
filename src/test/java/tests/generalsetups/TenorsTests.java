package tests.generalsetups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.generalsetups.TenorsPage;
import tests.BaseTest;

public class TenorsTests extends BaseTest {


    public TenorsPage tenorsPage;

    private static final Logger logger = LoggerFactory.getLogger(TenorsTests.class);

    @BeforeTest
    public void settingUp() {
        tenorsPage = new TenorsPage(webDriver);
    }

    @Test
    public void setupTenorTest() {

        logger.info("Creating the tenor started..........");
        tenorsPage.createTenor();
        logger.info("Tenor successfully created !");

        logger.info("Tenor - approving pending started.......");
        tenorsPage.approvePendingTenor();
        logger.info("Tenor approved successfully !!!!");

        logger.info("Update process for tenor started........... ");
        tenorsPage.updateTenor();
        logger.info("Tenor successfully updated !!!");

        logger.info("Deleting the tenor initiated...........");
        tenorsPage.deletingTenor();
        logger.info("Tenor successfully deleted  !!!");


    }


}
