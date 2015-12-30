import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CopyOfcreateAndEditUser {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://test-web-auth.retailcs.awsdev.infor.com/");

		// Create a User
		// Click on Create User
		driver.findElement(By.xpath("//*[@id='react-view']/div/div[1]/ul/li[2]/ul/li/a")).click();

		// Fill in the new user form
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("TesterRaju1");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("RajuTesterLastname1");
		driver.findElement(By.xpath("//*[@id='title']")).sendKeys("srmanager1");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("test1123@gm1ail.com");
		driver.findElement(By.xpath("//*[@id='phoneNumber']")).sendKeys("6118501933");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("testrajutest11");
		driver.findElement(By.xpath("//*[@id='employeeId']")).sendKeys("5678901");
		// Save the User form
		driver.findElement(By.xpath("//*[@id='main-view']/div/div[1]/form/div[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Yes I create a user successfully");

		//
		System.out.println("Okay lets find this created user in webtable please");

		// Find the newly created user in the webtable which has list of all
		// created users
		WebElement userhtmltable = driver.findElement(By.xpath("//*[@id='main-view']/div/table/tbody"));

		// To Locate rows of table
		List<WebElement> rows_usertable = userhtmltable.findElements(By.tagName("tr"));

		// To calculate no of rows in table

		int rows_usercount = rows_usertable.size();
		System.out.println("No of rows in the User webtable are " + rows_usercount);

		// Now lets add a loop

		for (int row = 0; row < rows_usercount; row++) {

			// To locate columns(cells) of that specific row.

			List<WebElement> Columns_row = rows_usertable.get(row).findElements(By.tagName("td"));

			// To calculate no of columns(cells) In that specific row.

			int columns_count = Columns_row.size();
			System.out.println("Number of cells In Row " + row + " are " + columns_count);

			// Loop will execute till the last cell of that specific row.
			
			int column = 0;
			String celtext = Columns_row.get(column).getText();
		
			if(celtext == "5678901" ){
			
				for (column = 0; column < columns_count; column++) {
					// To retrieve text from that specific cell.
					//String celtext = Columns_row.get(column).getText();

					System.out.println(
							"Cell Value Of row number " + row + " and column number " + column + " Is " + celtext);

					/*
					 * if (celtext == "567890") {
					 * 
					 * driver.findElement(By.xpath(
					 * "//*[@id='main-view']/div/table/tbody/tr[" + row +
					 * "]/td[1]/div/a")) .click();
					 * 
					 * 
					 * }
					 */

					/*
					 * if (celtext.equalsIgnoreCase("lastnametest301")) { // If
					 * the sValue match with the description, it will initiate
					 * one more inner loop for all the columns of 'i' row for
					 * (int j=1;j<=5;j++){ String sColumnValue=
					 * driver.findElement(By.xpath(
					 * "//*[@id='main-view']/div/table/tbody/tr[" + i + "]/td["+
					 * j +"]")).getText(); System.out.println(sColumnValue);
					 * 
					 * }
					 */

				}
			}

		}

		// driver.close();

	}
}
