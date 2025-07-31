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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

// Open the demoqa.com website
WebUI.openBrowser('')

WebUI.navigateToUrl('https://demoqa.com/')
WebUI.scrollToElement(findTestObject('Object Repository/Page_DEMOQA/CLickBookStrore'), 10)
WebUI.click(findTestObject('Object Repository/Page_DEMOQA/CLickBookStrore'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_DEMOQA/select_5 rows10 rows20 rows25 rows50 rows100 rows'), 10, FailureHandling.STOP_ON_FAILURE)
WebUI.click(findTestObject('Object Repository/Page_DEMOQA/select_5 rows10 rows20 rows25 rows50 rows100 rows'))


WebUI.selectOptionByValue(findTestObject('Object Repository/Page_DEMOQA/select_5 rows10 rows20 rows25 rows50 rows100 rows'),
	'5', true)

WebUI.click(findTestObject('Object Repository/Page_DEMOQA/button_Next'))

WebUI.click(findTestObject('Object Repository/Page_DEMOQA/button_Previous'))
WebUI.click(findTestObject('Object Repository/Page_DEMOQA/book_Speaking_JavaScript'), FailureHandling.STOP_ON_FAILURE)

/*
*  Automate browser interaction to navigate a demo website and manipulate table pagination controls.
*
*  1. Open a new browser window.
*  2. Navigate to the URL 'https://demoqa.com/'.
*  3. Scroll to a specific SVG element on the page, waiting up to 30 seconds and stopping on failure.
*  4. Click on the identified SVG element.
*  5. Select the option with value '5' from a dropdown menu controlling the number of rows displayed.
*  6. Click the 'Next' button to navigate to the next page of the table.
*  7. Click the 'Previous' button to navigate back to the previous page of the table.
*
*/
