package PageObjectsTricentis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class LandingPageTricentisPage extends AbstractComponent {

	WebDriver driver;

	public LandingPageTricentisPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav_automobile")
	WebElement nav_automobileBtn;

	public void openWebsite() {
		
		driver.get("https://sampleapp.tricentis.com/101/#");
	}

	public void nav_automobileClick() {
		
		Assert.assertTrue(nav_automobileBtn.isEnabled(), "nav_automobileBtn Is Disabled.");
		nav_automobileBtn.click();
	}
}
