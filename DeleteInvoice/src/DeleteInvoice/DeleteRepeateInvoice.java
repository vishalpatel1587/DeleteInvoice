
/*********** This packages is used to search for an invoice for a customer entered by user using the search functionality,
 selecting the first invoice and deleting \ the invoice. It also checks for the confirmation message.**************/

package DeleteInvoice;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Login.Login;
import POM.POM;

public class DeleteRepeateInvoice {

	public static void main(String[] args) {
		
		try
		{
		WebDriver driver =  new FirefoxDriver();
			
			// waits for the firefox to load
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
			// Gets to the page mentioned below
			driver.get("https://www.xero.com/signup/");
			
			//Calls the Login function which logins to the site.
			Login.LoginScreen(driver);
			
			//Waits for the page to load
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			//Navigates to Account
			POM.Account(driver).click();
			
			//Navigates to Sales
			POM.Sales(driver).click();
			
			//Navigates to Repeating tab
			POM.RepeatingTab(driver).click();
			
			//Clicks on the Search button to search for invoice
			POM.SearchInvoice(driver).click();
			
			//Enters the text SAM to search for SAM's invoices
			POM.EnterText(driver).sendKeys("SAM");
			
			//Clicks on Search button to begin the search
			POM.SearchButton(driver).click();
			
			//Selects the First invoice.
			POM.SelectFirstRow(driver).click();
			
			//Deletes the selected invoice.
			POM.DeleteInvoice(driver).click();

			//Responds to the confirmation message in affirmation.
			POM.Confirmation(driver).click();
			
			//Verifies the message of confirmation that is populated to the user on the screen once the message is deleted.
			POM.VerifyMessageDeleted(driver);
			//Provides a user friendly message saying that the selected invoice has been deleted.
			System.out.println("The selected repeating invoice has been successfully deleted!");
		
		}
		catch(Throwable e)
		{
			//Gives an error to user if the code falls out in any of the above task.
			System.out.println("Exception occured in the flow. try again!");
		}
	}

}
