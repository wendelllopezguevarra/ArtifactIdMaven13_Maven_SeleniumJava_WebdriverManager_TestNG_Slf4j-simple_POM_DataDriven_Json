package PageObjectsTricentis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class AutomobileEnterProductDataTricentisPage extends AbstractComponent{
	WebDriver driver;
	
	public AutomobileEnterProductDataTricentisPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "startdate")
	WebElement startdateText; 
	
	@FindBy(id = "damageinsurance")
	WebElement damageinsuranceList;
	
	@FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[3]/div[5]/p/label[2]/span")
	WebElement legalDefenseInsuranceCheckBtn;
	
	@FindBy(id = "courtesycar")
	WebElement courtesycarList; 
	
	@FindBy(id = "nextselectpriceoption")
	WebElement nextselectpriceoptionBtn;
	
	public void inputAutomobileEnterProductDataTricentisPage() {
		startdateText.sendKeys("06/01/2024");
		Assert.assertEquals(startdateText.getAttribute("value"), "06/01/2024", "startdateText Mismatched: Value or Synchronisation.");
		
		Select damageinsuranceSelect = new Select(damageinsuranceList);
		damageinsuranceSelect.selectByVisibleText("Full Coverage");
		Assert.assertEquals(damageinsuranceList.getAttribute("value"), "Full Coverage", "damageinsuranceList Mismatched: Value or Synchronisation.");
		
		Assert.assertTrue(legalDefenseInsuranceCheckBtn.isEnabled(), "legalDefenseInsuranceCheckBtn Is Disabled.");
		legalDefenseInsuranceCheckBtn.click();
		
		Select courtesycarSelect = new Select(courtesycarList);
		courtesycarSelect.selectByVisibleText("Yes");
		Assert.assertEquals(courtesycarList.getAttribute("value"), "Yes", "courtesycarList Mismatched: Value or Synchronisation.");

		Assert.assertTrue(nextselectpriceoptionBtn.isEnabled(), "nextselectpriceoptionBtn Is Disabled.");
		nextselectpriceoptionBtn.click();
	}
}
