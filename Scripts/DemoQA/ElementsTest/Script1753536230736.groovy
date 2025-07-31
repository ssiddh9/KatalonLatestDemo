import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com')
WebUI.scrollToElement(findTestObject('Object Repository/DemoQA/Elements/Elements'), 10)
WebUI.click(findTestObject('Object Repository/DemoQA/Elements/Elements'))

List<WebElement> elements =WebUI.findWebElements(findTestObject('Object Repository/DemoQA/Elements/listOfelements'), 10)


def text=WebUI.getText(findTestObject('Object Repository/DemoQA/Elements/testelement'))

println(text)
for (int i = 1;  i < elements.size(); i++) {
	KeywordUtil.logInfo(CustomKeywords.'myPack.WebUIhack.listofelements'(i))
	}
	
	CustomKeywords.'myPack.WebUIhack.selectTextBox'()
	WebUI.delay(3)
	CustomKeywords.'myPack.WebUIhack.fillForm'("John Doe", "john@example.com", "123 Main St", "456 Other St")
	WebUI.delay(3)
	String output = CustomKeywords.'myPack.WebUIhack.getOutputText'()
	assert output.contains("John Doe");
	assert output.contains("john@example.com");
	assert output.contains("123 Main St");
	assert output.contains("456 Other St");

      /*
      *  Automate interaction with a demo web page by navigating, clicking elements, logging information, filling a form, and verifying output.
      *
      *  1. Open a browser and navigate to the demo QA website.
      *  2. Scroll to and click on the "Elements" section.
      *  3. Find a list of elements on the page and retrieve text from a specific element.
      *  4. Log information for each element in the list using a custom keyword.
      *  5. Use custom keywords to select a text box, fill a form with given data, and retrieve output text.
      *  6. Assert that the output text contains the expected form input values.
      *
      */