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

/*1. Open Browser in full screen mode and navigate to the URL:"https://demoqa.com"
 * WaitforElement to be visible 
 * Click on Elements
 * 
 * 
 */
// Open browser and navigate to the URL "https://demoqa.com"
WebUI.openBrowser('https://demoqa.com')
// Maximize the browser window to full screen
WebUI.maximizeWindow()
// Wait for the "Elements" element to be visible
WebUI.waitForElementVisible(findTestObject('Object Repository/DemoQA/Elements/Elements'), 30)
// Click on the "Elements" element
WebUI.scrollToElement(findTestObject('Object Repository/DemoQA/Elements/Elements'), 10)
WebUI.click(findTestObject('Object Repository/DemoQA/Elements/Elements'))


