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

import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

// Open the demoqa.com website
WebUI.openBrowser('')
WebUI.navigateToUrl('https://demoqa.com')

// Click on Elements
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Elements'))

// Get List of Items under Elements
WebUI.delay(2) // Adding a delay for the list to be fully loaded

// Select Text Box
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Text Box'))

// Enter details and submit the form
 String fullName = 'John Doe'
 String email = 'john.doe@example.com'
 String currentAddress = '123 Main St'
 String permanentAddress = '456 Elm St'

WebUI.setText(findTestObject('Object Repository/Page_DemoQA/Full Name'), fullName)
WebUI.setText(findTestObject('Object Repository/Page_DemoQA/Email'), email)
WebUI.setText(findTestObject('Object Repository/Page_DemoQA/Current Address'), currentAddress)
WebUI.setText(findTestObject('Object Repository/Page_DemoQA/Permanent Address'), permanentAddress)

WebUI.click(findTestObject('Object Repository/Page_DemoQA/Submit'))

// Fetch the output generated post submission and verify each field
String outputFullName = WebUI.getText(findTestObject('Object Repository/Page_DemoQA/Output Full Name'))
String outputEmail = WebUI.getText(findTestObject('Object Repository/Page_DemoQA/Output Email'))
String outputCurrentAddress = WebUI.getText(findTestObject('Object Repository/Page_DemoQA/Output Current Address'))
String outputPermanentAddress = WebUI.getText(findTestObject('Object Repository/Page_DemoQA/Output Permanent Address'))

// Verify each output
evaluateFullName = outputFullName.contains(fullName)
evaluateEmail = outputEmail.contains(email)
evaluateCurrentAddress = outputCurrentAddress.contains(currentAddress)
evaluatePermanentAddress = outputPermanentAddress.contains(permanentAddress)

assert evaluateFullName : 'Full Name verification failed'
assert evaluateEmail : 'Email verification failed'
assert evaluateCurrentAddress : 'Current Address verification failed'
assert evaluatePermanentAddress : 'Permanent Address verification failed'

// Click on Alerts, Frames & Windows
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Alerts, Frames & Windows'))

// Click Frames
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Frames'))

// Get details from both the text box
WebUI.switchToFrame(findTestObject('Object Repository/Page_DemoQA/Frames'), 10)
WebDriver driver = DriverFactory.getWebDriver()
String frameText = driver.findElement(By.xpath('//*[@id="frame"]')).getText()
WebUI.comment('Text inside the frame: ' + frameText)
WebUI.switchToDefaultContent()

// Click on Alerts
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Alerts'))

// Click on ‘Click me’ next to On button click,
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Click Me Button'))

// Confirm box will appear, fetch the output text generated in the popup and click on OK
String alertText = WebUI.getAlertText()
WebUI.comment('Alert text: ' + alertText)
WebUI.acceptAlert()

// Click Browser Windows
WebUI.click(findTestObject('Object Repository/Page_DemoQA/Browser Windows'))

// Click on New Tab and get text from it.
WebUI.click(findTestObject('Object Repository/Page_DemoQA/New Tab'))
WebUI.switchToWindowIndex(1) // Switch to the new tab
String newTabText = WebUI.getText(findTestObject('Object Repository/Page_DemoQA/New Tab Text'))
WebUI.comment('Text from new tab: ' + newTabText)

// Close the new tab and return to original tab
WebUI.closeWindowIndex(1)
WebUI.switchToWindowIndex(0)

// Close the browser
WebUI.closeBrowser()