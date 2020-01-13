package selenium_tests.page_object_model;

import org.openqa.selenium.By;

public class POM_LoginPage {
	
	public static By linkLogin_Signup = By.linkText("Login/Signup");
	public static By lblLadingPageHeader = By.xpath("//h1[text()='The Bookie']");
	public static By linkSignup = By.linkText("Signup");
	public static By inputemailid = By.id("email");
	public static By inputpassword = By.id("password");
	public static By btnLogin = By.xpath("//span[text()='Log In']/parent::button");
	public static By lblPlanner = By.xpath("//span[text()='Planner']");
	public static By errmsg = By.xpath("//span[text()='Invalid user or password, please reenter']");
}
