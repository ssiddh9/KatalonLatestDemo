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

WebUI.navigateToUrl('https://www.orangehrm.com/en/book-a-free-demo')

WebUI.setText(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_Full Name_FullName'), 
    'Siddharth')

WebUI.setText(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_Phone Number_Contact'), 
    '9766542727')

WebUI.setText(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_Email_Email'), 'ssiddh9@gmail.com')

WebUI.setText(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_Company Name_CompanyName'), 
    'Infosys')

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/select_CountryAfghanistanAlbaniaAlgeriaAmer_8f0376'), 
    'India', true)

WebUI.selectOptionByValue(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/select_Number of Employees  1011 - 5051 - 2_706fa0'), 
    '51 - 200', true)

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/katalon-div_id(katalon-rec_elementInfoDiv)'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/div'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/katalon-div_id(katalon-rec_elementInfoDiv)'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/div'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_No Of Employees_action_submitForm'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_No Of Employees_action_submitForm'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/div_reCAPTCHA_recaptcha-checkbox-border'))

WebUI.click(findTestObject('Object Repository/Page_Book Your Free Demo  OrangeHRM HR Software/input_No Of Employees_action_submitForm'))

WebUI.closeBrowser()


/*
 * open Browser and navigate to ("https://www.orangehrm.com/en/book-a-free-demo")
 * To Fill the Form Generate the Test Data 
 * 
 */

// Open browser and navigate to the specified URL
WebUI.openBrowser('https://www.orangehrm.com/en/book-a-free-demo')

// Maximize the browser window
WebUI.maximizeWindow()

// Generate test data for the form fields
String firstName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(6)
String lastName = org.apache.commons.lang.RandomStringUtils.randomAlphabetic(8)
String email = firstName.toLowerCase() + '.' + lastName.toLowerCase() + '@example.com'
String phone = org.apache.commons.lang.RandomStringUtils.randomNumeric(10)
String company = 'TestCompany' + org.apache.commons.lang.RandomStringUtils.randomAlphanumeric(4)
String jobTitle = 'QA Engineer'
String employees = '51 - 75'
String country = 'United States'

// Set the First Name field
WebUI.setText(findTestObject('Object Repository/OrangeHRM/Form/input_FirstName'), firstName)

// Set the Last Name field
WebUI.setText(findTestObject('Object Repository/OrangeHRM/Form/input_LastName'), lastName)

// Set the Work Email field
WebUI.setText(findTestObject('Object Repository/OrangeHRM/Form/input_Email'), email)

// Set the Phone Number field
WebUI.setText(findTestObject('Object Repository/OrangeHRM/Form/input_Phone'), phone)

// Set the Company Name field
WebUI.setText(findTestObject('Object Repository/OrangeHRM/Form/input_Company'), company)

// Set the Job Title field
WebUI.setText(findTestObject('Object Repository/OrangeHRM/Form/input_JobTitle'), jobTitle)

// Select the Number of Employees from dropdown by label
WebUI.selectOptionByLabel(findTestObject('Object Repository/OrangeHRM/Form/select_Employees'), employees, false)

// Select the Country from dropdown by label
WebUI.selectOptionByLabel(findTestObject('Object Repository/OrangeHRM/Form/select_Country'), country, false)
