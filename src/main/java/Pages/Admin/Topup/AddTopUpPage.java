package Pages.Admin.Topup;

import Pages.BasePage;
import com.shaft.cli.FileActions;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddTopUpPage extends BasePage {
    public AddTopUpPage(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    By branchList = By.id("branchId");
    By agencyList = By.id("agnecyId");
    By topUpLimit = By.id("topup-amount");
    By receiptNo = By.id("receipt-no");
    By uploadBttn = By.id("chooseDoct");
    By sendForApprovalBttn = By.xpath("/html/body/div/section/div/div[2]/div/div/div[2]/form/div/div[5]/input[1]");
    By statusMssg = By.id("statusMsg");

    public By errorMsg = By.id("ErrorReceiptNo");

    public void addTopUpTOBranchWithValidData(String branchName, String topuplimit, String receiptno) {
        driver.element().select(branchList, branchName);
        driver.element().type(topUpLimit,topuplimit);
        driver.element().type(receiptNo, receiptno);
        driver.element().typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"));
        driver.element().click(sendForApprovalBttn);
        driver.assertThat().element(statusMssg).isVisible();
    }

    public void addTopUpTOBranchWithInValidData(String branchName, String topuplimit, String receiptno) {
        driver.element().select(branchList, branchName)
        .type(topUpLimit,topuplimit)
        .type(receiptNo, receiptno)
        .typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"))
        .click(sendForApprovalBttn);
    }

    public void addTopUpTOBranchWithEmptyData() {
        driver.element().click(sendForApprovalBttn);
    }

    public void addTopUpTOBranchWithEmptyBranch(String topuplimit, String receiptno) {
        driver.element().type(topUpLimit,topuplimit)
                .type(receiptNo, receiptno)
                .typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"))
                .click(sendForApprovalBttn);
    }

    public void addTopUpTOBranchWithEmptytopuplimit(String branchName, String receiptno) {
        driver.element().select(branchList, branchName)
                .type(receiptNo, receiptno)
                .typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"))
                .click(sendForApprovalBttn);
    }

    public void addTopUpTOBranchWithEmptyreceiptno(String branchName, String topuplimit) {
        driver.element().select(branchList, branchName)
                .type(topUpLimit,topuplimit)
                .typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"))
                .click(sendForApprovalBttn);
    }

    public void addTopUpTOBranchWithEmptyFile(String branchName, String topuplimit, String receiptno) {
        driver.element().select(branchList, branchName)
                .type(topUpLimit,topuplimit)
                .type(receiptNo, receiptno)
                .click(sendForApprovalBttn);
    }

    public void addTopUpTOAgencyWithValidData(String branchName, String agencyName, String topuplimit, String receiptno) {
        driver.element().select(branchList, branchName);
        driver.element().select(agencyList, agencyName);
        driver.element().type(topUpLimit, String.valueOf(topuplimit));
        driver.element().type(receiptNo, String.valueOf(receiptno));
        driver.element().typeFileLocationForUpload(uploadBttn, FileActions.getInstance().getAbsolutePath(SHAFT.Properties.paths.testData(), "images.png"));
        driver.element().click(uploadBttn);
        //driver.element().Click(sendForApprovalBttn);
       // driver.assertThat().element(statusMssg).isVisible();


    }
}
