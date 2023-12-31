package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.ContactPage;
import pages.HomePage;
import org.junit.Assert;
import java.util.Map;

public class ContactSteps {

    HomePage homePage;
    ContactPage contactPage;
    String foreName = "";

    @Given("I am on the Jupiter Toys home page")
    public void navigateToHomepage() {
        homePage = new HomePage();
    }


    @Given("^I navigate to (.*) page$")
    public void navigateToAnotherPage(String menu) {

        homePage.selectMenuItem(menu);
    }

    @When("^I enter the following values into the form and (.*)$")
    public void submitFormData(String submitForm, DataTable dataTable) {
        Map<String, String> formData = dataTable.asMap(String.class, String.class);

        contactPage = new ContactPage();

        boolean submitFormData = false;
        if (submitForm.equalsIgnoreCase("submit"))
            submitFormData = true;
        contactPage.enterFormData(formData, submitFormData);

        // store the forename to use it for validation in the later step
        if (formData.containsKey("Forename"))
            foreName = formData.get("Forename");
    }

    @Then("I should get the following error messages")
    public void validateErrorMessages(DataTable dataTable) {
        Map<String, String> expectedErrorMessages = dataTable.asMap(String.class, String.class);

        Map<String, String> actualErrorMessages = contactPage.getErrorMessages();

        for (String error : expectedErrorMessages.keySet()){
            Assert.assertEquals("Expected " + error + " error message to be " +
                            expectedErrorMessages.get(error) +
                            " but got " + actualErrorMessages.get(error),
                    expectedErrorMessages.get(error), actualErrorMessages.get(error));
        }

    }

    @Then("I should not get any error messages")
    public void validateForNoErrorMessages() {
        Map<String, String> actualErrorMessages = contactPage.getErrorMessages();

        for (String error : actualErrorMessages.keySet()){
            Assert.assertEquals("Was not expecting error message for " + error + "field after entering value, but got "
                    + actualErrorMessages.get(error),
                    "", actualErrorMessages.get(error));
        }
    }

    @Then("^I should see the successful submission message like (.*)$")
    public void validateSuccessfulSubmissionMessage(String expectedMessage){
        // replace <forname> placeholder in message with actual Forename
        expectedMessage = expectedMessage.replace("<forename>", foreName);

        String actualMessage = contactPage.getSuccessMessage();

        Assert.assertEquals("Expected success message to be " +
                        expectedMessage + " , but got " + actualMessage,
                        expectedMessage, actualMessage);
    }
}
