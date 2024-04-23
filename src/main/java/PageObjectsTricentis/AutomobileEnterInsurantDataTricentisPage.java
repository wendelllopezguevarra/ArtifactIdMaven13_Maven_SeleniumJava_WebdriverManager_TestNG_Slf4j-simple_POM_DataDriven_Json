package PageObjectsTricentis;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class AutomobileEnterInsurantDataTricentisPage extends AbstractComponent{
	WebDriver driver;
	
	public AutomobileEnterInsurantDataTricentisPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "firstname")
	WebElement firstnameText; 
	
	@FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[2]/div[4]/p/label[1]/span")
	WebElement gendermaleRadioBtn; 
	
	@FindBy(id = "country")
	WebElement countryList; 
	
	@FindBy(xpath = "//*[@id=\"insurance-form\"]/div/section[2]/div[10]/p/label[5]/span")
	WebElement otherCheckBtn; 
	
	@FindBy(id = "nextenterproductdata")
	WebElement nextenterproductdataBtn; 
	
	public void inputAutomobileEnterInsurantDataTricentisPage(
			String firstnameTextj,
			String countryListj) {
		
		firstnameText.sendKeys(firstnameTextj);
		Assert.assertEquals(firstnameText.getAttribute("value"), firstnameTextj, "firstnameText Mismatched: Value or Synchronisation.");

		Assert.assertTrue(gendermaleRadioBtn.isEnabled(), "gendermaleRadioBtn Is Disabled.");
		gendermaleRadioBtn.click();
		
		Select countrySelect = new Select(countryList);
		countrySelect.selectByVisibleText(countryListj);
		Assert.assertEquals(countryList.getAttribute("value"), countryListj, "countryList Mismatched: Value or Synchronisation.");
		
		Assert.assertTrue(otherCheckBtn.isEnabled(), "otherCheckBtn Is Disabled.");
		otherCheckBtn.click();
		
		Assert.assertTrue(nextenterproductdataBtn.isEnabled(), "nextenterproductdataBtn Is Disabled.");
		nextenterproductdataBtn.click();
	}
}
