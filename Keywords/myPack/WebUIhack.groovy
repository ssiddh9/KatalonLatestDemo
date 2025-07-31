package myPack

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import internal.GlobalVariable

public class WebUIhack {
	WebDriver driver = DriverFactory.getWebDriver()

	@Keyword

	public void waitForelementVisibleThenClick(TestObject to,int timeout) {

		boolean loop= true;
		while (loop) {

			if(WebUI.waitForElementVisible(to, timeout)) {

				WebUI.click(to)
				loop=false
			}
		}
	}

	@Keyword
	public String listofelements(int num) {

		//driver.findElement(By.xpath("((//*[text()='Elements']/following::div/ul)[1]/li/span[@class='text'])["+num+"]")).getText()
		String text=driver.findElement(By.xpath("(//*[@id='item-"+num+"']/span)[1]")).getText()
		return text
	}
	
	@Keyword
	public String datalist(int num) {

		//driver.findElement(By.xpath("((//*[text()='Elements']/following::div/ul)[1]/li/span[@class='text'])["+num+"]")).getText()
		String text=driver.findElement(By.xpath("(//div[@class='oxd-table-cell oxd-padding-cell']/div)["+num+"]")).getText()
		println(num)
		println(text)
		return text
	}
	

	@Keyword
	public void fillForm(String name, String email, String currentAddress, String permanentAddress) {
		driver.findElement(By.id("userName")).sendKeys(name);
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("currentAddress")).sendKeys(currentAddress);
		driver.findElement(By.id("permanentAddress")).sendKeys(permanentAddress);
		driver.findElement(By.id("submit")).click();
	}

	@Keyword
	public void selectTextBox() {
		driver.findElement(By.xpath("//span[text()='Text Box']")).click();
	}

	@Keyword
	public String getOutputText() {
		return driver.findElement(By.id("output")).getText();
	}
	/*
	 * Generate CustomKeyword for Click button
	/*
	 * Clicks a button TestObject
	 * Generate TEst
	 *
	 * @param testObjectPath The path to the button TestObject in the Object Repository
	 */
	
	
	@Keyword
	def clickButton(String testObjectPath) {
		// Click the button identified by the given TestObject path
		WebUI.click(findTestObject(testObjectPath))
	}
	
	
}

