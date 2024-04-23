package BaseTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import PageObjectsTricentis.AutomobileEnterInsurantDataTricentisPage;
import PageObjectsTricentis.AutomobileEnterProductDataTricentisPage;
import PageObjectsTricentis.AutomobileEnterVehicleDataTricentisPage;
import PageObjectsTricentis.LandingPageTricentisPage;
import Utilities.DataDrivenUtilitiesForJson;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestTricentis extends DataDrivenUtilitiesForJson {

	public LandingPageTricentisPage landingPageTricentisPage;

	public AutomobileEnterVehicleDataTricentisPage automobileEnterVehicleDataTricentisPage;
	public AutomobileEnterInsurantDataTricentisPage automobileEnterInsurantDataTricentisPage;
	public AutomobileEnterProductDataTricentisPage automobileEnterProductDataTricentisPage;

	public static WebDriver driver;

	public WebDriver initializeDriver() throws IOException {

		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\WELLA\\Desktop\\JAVA SELENUIM WENDELL\\major java folder\\"
				+ "ArtifactIdMaven13_SeleniumJava_WebdriverManager_TestNG_Slf4j-simple_POM_DataDriven_Json\\"
				+ "src\\main\\java\\Resources\\Global.properties");
		properties.load(fileInputStream);

		String whatBrowser = properties.getProperty("browser");
		String whatBrowserVersion = properties.getProperty("browserVersion");

		if (whatBrowser.equals("chrome")) {
			WebDriverManager.chromedriver().driverVersion(whatBrowserVersion).setup();
			driver = new ChromeDriver();
		} else if (whatBrowser.equals("firefox")) {
		} else if (whatBrowser.equals("edge")) {
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		return driver;
	}

	@BeforeMethod
	public void openBrowser() throws IOException {

		driver = initializeDriver();

		landingPageTricentisPage = new LandingPageTricentisPage(driver);

		automobileEnterVehicleDataTricentisPage = new AutomobileEnterVehicleDataTricentisPage(driver);
		automobileEnterInsurantDataTricentisPage = new AutomobileEnterInsurantDataTricentisPage(driver);
		automobileEnterProductDataTricentisPage = new AutomobileEnterProductDataTricentisPage(driver);

		System.out.println("SELENIUM AUTOMATION @BeforeMethod openBroser method..");
	}

	@AfterMethod
	public void closeBrowser() {
		
		driver.manage().deleteAllCookies();
		driver.quit();
		
		System.out.println("SELENIUM AUTOMATION @BeforeMethod openBroser method..");
	}
}
