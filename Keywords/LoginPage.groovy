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
import com.kms.katalon.core.testobject.ObjectRepository
import internal.GlobalVariable

public class LoginPage {
	
	
		
			// Define the properties for the elements
			TestObject usernameField = ObjectRepository.findTestObject('Object Repository/LoginObjects/username')
			TestObject passwordField = ObjectRepository.findTestObject('Object Repository/LoginObjects/password')
			TestObject loginButton = ObjectRepository.findTestObject('Object Repository/LoginObjects/LoginButton')
		
			// Method to perform login action
			void login(String username, String password) {
				WebUI.setText(usernameField, username)
				WebUI.setText(passwordField, password)
				WebUI.click(loginButton)
			}
		}

