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

/*
 * 1. Call Test Case ClickElements
 * 2.Click Text Box element
 * 3.Call Customkeyword fillForm
 * 4.Verify OutputText
 * 
 *  * 
 */
WebUI.callTestCase(findTestCase('DemoQA/ClickElements'), [:], FailureHandling.STOP_ON_FAILURE)
CustomKeywords.'myPack.WebUIhack.selectTextBox'()
WebUI.delay(3)
//CustomKeywords.'myPack.WebUIhack.fillForm'('John Doe', 'john@example.com', '123 Main St', '456 Other St')
CustomKeywords.'myPack.WebUIhack.fillForm'(FullName, email, CurrentAdd, PermAdd)
WebUI.delay(3)
String output = CustomKeywords.'myPack.WebUIhack.getOutputText'()

assert output.contains(FullName)

assert output.contains(email)

assert output.contains(CurrentAdd)

assert output.contains(PermAdd)

