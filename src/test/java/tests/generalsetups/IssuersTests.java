package tests.generalsetups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.generalsetups.IssuersPage;
import tests.BaseTest;

public class IssuersTests extends BaseTest {

    public IssuersPage issuersPage;
    private static final Logger logger = LoggerFactory.getLogger(IssuersTests.class);

    @BeforeTest
    public void initializeDriver() {
        issuersPage = new IssuersPage(webDriver);

    }


    @Test
    public void creatingIssuer() {
        logger.info("Creating Issuer started................");
        issuersPage.createIssuer();
        logger.info("Issue successfully created  !!!");
        logger.info("Approving created Issue started.........");
        issuersPage.approvePendingIssuer();
        logger.info("Created Issuer has been successfully approved");
        logger.info("Update Issuer process started ..............");
        issuersPage.updateIssuer();
        issuersPage.approvePendingIssuer();
        issuersPage.confirmIssuerUpdate();
        logger.info("Issuer Update process works successfully   !!!");
        logger.info("Deletion process for Issuer initiated.............");
        issuersPage.deleteTestIssuer();
        logger.info("Issuer successfully deleted  !!!");

    }


}
