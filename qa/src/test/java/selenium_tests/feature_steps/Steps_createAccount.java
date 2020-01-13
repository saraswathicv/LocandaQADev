package selenium_tests.feature_steps;

import static selenium_tests.Runner.driver;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium_tests.page_object_model.POM_LoginPage;
import selenium_tests.page_object_model.POM_createAccount;


public class Steps_createAccount {
	
	private String name="Annie123";
	private String lastName="Besant12";
	private String emailid="Annei233@wipro.com";
	private String phoneNumber="48454843731";

	@Given("customer is on landing page of Locanda Application")
	public void customer_is_on_landing_page_of_Locanda_Application() throws Exception {
		driver.get().set_home_url(System.getProperty("env.qa.url"));
		driver.get().esm.wait_for_page_load();
		driver.get().esm.wait_element_visible(POM_LoginPage.lblLadingPageHeader);
		Thread.sleep(10000);
		Assert.assertTrue( driver.get().esm.check_element_displayed(POM_LoginPage.linkLogin_Signup));
	
	}

	@When("customer create a new account in Locanda")
	public void customer_create_a_new_account_in_Locanda() throws Exception {
		Thread.sleep(20000);
		Assert.assertTrue(driver.get().esm.check_element_displayed(POM_LoginPage.linkLogin_Signup));
		//driver.get().esm.wait_element_clickable(POM_LoginPage.linkLogin_Signup);
		//Thread.sleep(20000);
		driver.get().esm.click(POM_LoginPage.linkLogin_Signup);
		Thread.sleep(20000);
		driver.get().esm.wait_element_invisible(POM_LoginPage.linkLogin_Signup);
		driver.get().esm.wait_for_page_load();
		Assert.assertTrue(driver.get().esm.check_element_displayed(POM_LoginPage.linkSignup));
		driver.get().esm.wait_element_clickable(POM_LoginPage.linkSignup);
		driver.get().esm.click(POM_LoginPage.linkSignup);
		Thread.sleep(20000);
		driver.get().esm.wait_element_invisible(POM_LoginPage.linkSignup);
		driver.get().esm.wait_for_page_load();
		Assert.assertTrue(driver.get().esm.check_element_displayed(POM_createAccount.headerCreateAccount));
		fillDetailsinCreateAccount(name,lastName,emailid,phoneNumber);
		driver.get().esm.wait_element_invisible(POM_createAccount.btnCreateAccount);
		Assert.assertTrue(driver.get().esm.check_element_displayed(POM_createAccount.txtCreateAccountSuccessfulMessage));
		System.out.println("sara  "+driver.get().esm.get_text(POM_createAccount.txtPassword) );
	}

	@Then("custome able to login with newly ceated account")
	public void custome_able_to_login_with_newly_ceated_account() throws Exception {
		Thread.sleep(20000);
		driver.get().esm.click(POM_LoginPage.linkLogin_Signup);
		Thread.sleep(20000);
		driver.get().esm.wait_element_invisible(POM_LoginPage.linkLogin_Signup);
		driver.get().esm.wait_for_page_load();
		login(emailid,"");
		
	}

	@Then("customer is not allowed to create new accout with already registerd details")
	public void customer_is_not_allowed_to_create_new_accout_with_already_registerd_details() throws Exception {
		Thread.sleep(20000);
		driver.get().esm.click(POM_LoginPage.linkLogin_Signup);
		Thread.sleep(20000);
		driver.get().esm.wait_element_invisible(POM_LoginPage.linkLogin_Signup);
		driver.get().esm.wait_for_page_load();
		driver.get().esm.wait_element_clickable(POM_LoginPage.linkSignup);
		driver.get().esm.click(POM_LoginPage.linkSignup);
		Thread.sleep(20000);
		driver.get().esm.wait_element_invisible(POM_LoginPage.linkSignup);
		driver.get().esm.wait_for_page_load();
		Assert.assertTrue(driver.get().esm.check_element_displayed(POM_createAccount.headerCreateAccount));
		fillDetailsinCreateAccount(name,lastName,emailid,phoneNumber);
	}

	@When("customer tries to login with invalid credentails")
	public void customer_tries_to_login_with_invalid_credentails() throws Exception {
		Thread.sleep(20000);
		driver.get().esm.click(POM_LoginPage.linkLogin_Signup);
		Thread.sleep(20000);
		driver.get().esm.wait_element_invisible(POM_LoginPage.linkLogin_Signup);
		driver.get().esm.wait_for_page_load();
		login(emailid,"password");
	}

	@Then("customer is not allowed to login")
	public void customer_is_not_allowed_to_login() {
		Assert.assertTrue(driver.get().esm.check_element_displayed(POM_LoginPage.errmsg));
	}
	
	public void fillDetailsinCreateAccount(String name, String lastName, String emailid, String phoneNumber) throws Exception {
		//driver.get().esm.wait(2000);
		Thread.sleep(300);
		driver.get().esm.send_keys(POM_createAccount.inputName, name);
		driver.get().esm.send_keys(POM_createAccount.inputLastName, lastName);
		driver.get().esm.send_keys(POM_createAccount.inputemailid, emailid);
		driver.get().esm.send_keys(POM_createAccount.inputPhoneNumber, phoneNumber);
		Thread.sleep(20000);
		driver.get().esm.click(POM_createAccount.btnCreateAccount);
		driver.get().esm.wait_for_page_load();
	}
	
	public void login(String emailid,String password) throws Exception {
		Thread.sleep(20000);
		driver.get().esm.send_keys(POM_LoginPage.inputemailid, emailid);
		driver.get().esm.send_keys(POM_LoginPage.inputpassword, password);
		driver.get().esm.click(POM_LoginPage.btnLogin);
		Thread.sleep(20000);
	}
}
