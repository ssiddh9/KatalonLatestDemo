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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.rightClick(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Make Appointment'))

WebUI.rightClick(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Demo account_form-control'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Demo account_form-control'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/label_Demo account'))

WebUI.verifyElementText(findTestObject('Object Repository/Page_CURA Healthcare Service/label_Demo account'), 'Demo account')

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Login'), 0)

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Username_username'), 'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Password_password'), 'g3/DOGG74jC3Flrr3yH+3D/yKbOqqUNM')

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.doubleClick(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.rightClick(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.doubleClick(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'), 0)

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Make Appointment'), 0)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_CURA Healthcare Service/select_Tokyo CURA Healthcare Center        _5b4107'), 
    'Seoul CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/label_Apply for hospital readmission'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/label_Medicaid'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/input_Visit Date (Required)_visit_date'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/th_'))

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/td_7'))

WebUI.setText(findTestObject('Object Repository/Page_CURA Healthcare Service/textarea_Comment_comment'), 'Please Book')

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Book Appointment'), 0)

WebUI.click(findTestObject('Object Repository/Page_CURA Healthcare Service/button_Book Appointment'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/a_Go to Homepage'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/h2_Appointment Confirmation'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_CURA Healthcare Service/p_Seoul CURA Healthcare Center'), 
    0)

WebUI.closeBrowser()

