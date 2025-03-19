package tests.generalsetups;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.generalsetups.Sectors;
import tests.BaseTest;

public class SectorsTests extends BaseTest {


    public Sectors sectors;

    private static final Logger logger = LoggerFactory.getLogger(SectorsTests.class);

    @BeforeMethod
    public void initializeSectorPage() {

        sectors = new Sectors(webDriver);

    }

    @Test
    public void setupSectorTest() {

        logger.info("Creating the Sector started.............");
        sectors.createSector();
        logger.info("Sector successfully created!!!");
        logger.info("Created Sector approval process started.........");
        sectors.approvePendingSector();
        logger.info("Created Sector has been successfully approved!");
        logger.info("Viewing the created Sector.............");
        sectors.viewCreatedSector();
        logger.info("Created Sector exists in the database!");
        logger.info("Updating the Sector's numeric code........");
        sectors.updateSector();
        logger.info("Updated the Sector's numeric code successfully!");
        logger.info("Deleting operation process for the Sector initiated......");
        sectors.deleteSectors();
        logger.info("Sector successfully deleted !!!");

    }

}
