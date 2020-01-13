package selenium_tests.page_object_model;

import org.openqa.selenium.By;

public class POM_createAccount {
	

	public static By headerCreateAccount = By.xpath("//h1[text()='Locanda - Create Account']");		
	public static By inputName = By.id("firstname");
	public static By inputLastName = By.id("surname");
	public static By inputemailid = By.id("email");
	public static By inputPhoneNumber = By.id("phone");
	public static By btnCreateAccount = By.xpath("//span[text()='Create Account']/parent::button");
	public static By txtCreateAccountSuccessfulMessage = By.xpath("//h1[text()='Locanda - Account created successfully']");
	public static By txtPassword = By.xpath("//div[@id='home']/p[2]/br[2]");
}
