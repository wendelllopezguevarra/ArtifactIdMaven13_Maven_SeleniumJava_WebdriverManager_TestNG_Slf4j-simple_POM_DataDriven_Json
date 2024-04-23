//no json
package PageObjectsTricentis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class AutomobileEnterVehicleDataTricentisPage extends AbstractComponent{
	WebDriver driver;
	
	public AutomobileEnterVehicleDataTricentisPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "make")
	WebElement makeList;
	
	@FindBy(id = "dateofmanufacture")
	WebElement dateofmanufactureText;
	
	@FindBy(id = "annualmileage")
	WebElement annualmileageText;
	
	@FindBy(id = "nextenterinsurantdata")
	WebElement nextenterinsurantdataBtn; 
	
	public void inputAutomobileEnterVehicleDataTricentisPage(
			String makeListj,
			String dateofmanufactureTextj,
			String annualmileageTextj) {
		
		Select makeSelect = new Select(makeList);
		makeSelect.selectByVisibleText(makeListj);
		Assert.assertEquals(makeList.getAttribute("value"), makeListj, "makeList Mismatched: Value or Synchronisation.");
		
		dateofmanufactureText.sendKeys(dateofmanufactureTextj);
		Assert.assertEquals(dateofmanufactureText.getAttribute("value"), dateofmanufactureTextj, "dateofmanufactureText Mismatched: Value or Synchronisation.");
		
		annualmileageText.sendKeys(annualmileageTextj);
		Assert.assertEquals(annualmileageText.getAttribute("value"), annualmileageTextj, "annualmileageText Mismatched: Value or Synchronisation.");
		
		Assert.assertTrue(nextenterinsurantdataBtn.isEnabled(), "nextenterinsurantdataBtn Is Disabled.");
		nextenterinsurantdataBtn.click();		
	}
}

