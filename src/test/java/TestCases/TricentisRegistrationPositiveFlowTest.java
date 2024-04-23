package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTests.BaseTestTricentis;

public class TricentisRegistrationPositiveFlowTest extends BaseTestTricentis{
	@Test(dataProvider = "getData")
	public void testRegistrationFlow(HashMap<String, String> input) {
		
		landingPageTricentisPage.openWebsite();
		landingPageTricentisPage.nav_automobileClick();
		
		automobileEnterVehicleDataTricentisPage.inputAutomobileEnterVehicleDataTricentisPage(
				input.get("makeListj"),
				input.get("dateofmanufactureTextj"),
				input.get("annualmileageTextj"));
		automobileEnterInsurantDataTricentisPage.inputAutomobileEnterInsurantDataTricentisPage(
				input.get("firstnameTextj"),
				input.get("countryListj"));
		automobileEnterProductDataTricentisPage.inputAutomobileEnterProductDataTricentisPage();
		
		System.out.println("SELENIUM AUTOMATION @Test testRegistrationFlow method..");
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") 
				+ "/src/main/java/Resources/TricentisJson2.json");
		// Convert List<HashMap> to Object[][]
		Object[][] dataArray = new Object[data.size()][1];
		for (int i = 0; i < data.size(); i++) {
			dataArray[i][0] = data.get(i);
		}
		return dataArray;
	}
}
