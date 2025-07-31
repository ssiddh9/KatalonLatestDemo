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

import org.openqa.selenium.WebElement;


/*
 * Open Browser 
 * Navigate to url"https://opensource-demo.orangehrmlive.com/"
 * Verify the Page 
 * Click to Admin Tab
 * Verify Admin Page
 * get the data from Table Present on it 
 * Verify Employee Name and Break the Test Once Verified 
 * 
 * 
 */

// Open browser
WebUI.openBrowser('')




// Navigate to url "https://opensource-demo.orangehrmlive.com/"
WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/')

// Verify the Page by checking the presence of login panel
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), 10)

// Set username
WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), 'Admin')

// Set password
WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

// Click Login button
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Login'))
// Verify Admin Tab is present
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/a_Admin'), 10)

// Click to Admin Tab
WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/a_Admin'))

// Verify Admin Page by checking presence of System Users header
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_OrangeHRM/h1_SystemUsers'), 10)

// Get the data from Table Present on it
List<WebElement> rows = WebUI.findWebElements(findTestObject('Object Repository/Page_OrangeHRM/table_SystemUsers'), 10)
println(rows)
// Loop through each row to verify Employee Name and break the test once verified
for (int i = 1; i <= rows.size(); i++) {
    // Get Employee Name cell text
	
    String employeeName = CustomKeywords.'myPack.WebUIhack.datalist'(i)
	println(employeeName)
	println(i)
	println(rows)
    // Verify Employee Name is not empty
    if (employeeName == "ddfgklgkccgv" && !employeeName.trim().isEmpty()) {
        // Employee Name verified, break the loop
		println(employeeName)
        break
    }
}