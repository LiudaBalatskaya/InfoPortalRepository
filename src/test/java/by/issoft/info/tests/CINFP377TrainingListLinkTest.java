package by.issoft.info.tests;


import static com.codeborne.selenide.Selenide.open;

import by.issoft.info.po.TrainingCenterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CINFP377TrainingListLinkTest extends BaseTest {
    private static TrainingCenterPage trainingCenterPage;


    @BeforeMethod
    public void openPage() {
        trainingCenterPage = open(TrainingCenterPage.URL, TrainingCenterPage.class);
    }


    @Test()
    public void verifyTrainingListBlock() {
        Assert.assertTrue(trainingCenterPage.isActiveTrainingListBlockLink(), "Link of Training list block is wrong");
    }
}
