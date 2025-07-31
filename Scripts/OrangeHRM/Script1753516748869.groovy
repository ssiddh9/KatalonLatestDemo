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
import org.openqa.selenium.By
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory

WebUI.openBrowser('')

WebUI.navigateToUrl('https://opensource-demo.orangehrmlive.com/web/index.php/auth/login')

WebUI.setText(findTestObject('Object Repository/Page_OrangeHRM/input_Username_username'), 'Admin')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_OrangeHRM/input_Password_password'), 'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/button_Login'))

WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/span_PIM'))

WebUI.delay(10)

// Get the WebDriver
WebDriver driver = DriverFactory.getWebDriver()

// Locate the table element
WebElement table = driver.findElement(By.xpath('//div[@class="oxd-table orangehrm-employee-list"]'))

// Get all rows from the table
//List<WebElement> rows = table.findElements(By.xpath('//div[@class="oxd-table orangehrm-employee-list"]/child::div[@class="oxd-table-body"]/div'))
List<WebElement> rows = table.findElements(By.xpath("//div[@class='oxd-table-cell oxd-padding-cell']"))
// Iterate through rows to read data
//for  (int i = 0; i < rows.size(); i++)  {
//	List<WebElement> cells = rows.get(i).findElements(By.xpath('(//div[@class="oxd-table orangehrm-employee-list"]/child::div[@class="oxd-table-body"]/div/div)["'+i+'"]/div/div'))
//	  for (int j = 0; j < cells.size(); j++) {
//		  String cellText = cells.get(j).getText().trim();
//		  if (!cellText.isEmpty()) {
//		println("Row " + (i + 1) + ", Column " + (j + 1) + ": " + cells.get(j).getText()) // Print the text of each cell
//	}
//	  }
//}

List<List<String>> tableData = new ArrayList<>();
List<String> rowData = new ArrayList<>();
 for (WebElement cell : rows) {
                String cellText = cell.getText().trim();
				if (!cellText.isEmpty()) {
                rowData.add(cellText);
 }
 }
 
//			if (!rowData.isEmpty()) {
				tableData.add(rowData);
//			}
 
 
 System.out.println("Extracted Table:");
 for (List<String> row : tableData) {
	 System.out.println(row);
 }
//WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/div_dfgsjsjdh'))
//
//WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/a_Personal Details'))
//
//WebUI.click(findTestObject('Object Repository/Page_OrangeHRM/div_dfgsjsjdh123445 34444444'))
//
//WebUI.closeBrowser()

