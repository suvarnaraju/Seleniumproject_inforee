import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class createAndEditUser {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://test-web-auth.retailcs.awsdev.infor.com/");

		// Create a User
		// Click on Create User
		driver.findElement(By.xpath("//*[@id='react-view']/div/div[1]/ul/li[3]/ul/li/a")).click();

		// Fill in the new user form
		driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys("user2raju");
		driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("user2rajulastname");
		driver.findElement(By.xpath("//*[@id='title']")).sendKeys("testmanager");
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("hydra@gmail.com");
		driver.findElement(By.xpath("//*[@id='phoneNumber']")).sendKeys("6128503133");
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("testingusername8");
		driver.findElement(By.xpath("//*[@id='employeeId']")).sendKeys("00008");
		// Save the User form
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='main-view']/div/div/div[1]/form/div[2]/input")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("Yes I create a user successfully");

		//
		System.out.println("Okay lets find this created user in webtable please");

		// Find the newly created user in the webtable which has list of all
		// created users
		WebElement userhtmltable = driver.findElement(By.xpath(".//*[@id='main-view']/div/div/div/div[2]/table/tbody"));

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

			String employeeId = Columns_row.get(7).getText();
			System.out.println("The employee id is --- "+employeeId);
			if (employeeId.equalsIgnoreCase("00008")) {
				for (int column = 0; column < columns_count; column++) {
					// To retrieve text from that specific cell.
					String celtext = Columns_row.get(column).getText();
					System.out.println(
							"Cell Value Of row number " + row + " and column number " + column + " Is " + celtext);

					driver.findElement(By.xpath("//*[@id='main-view']/div/div/div/div[2]/table/tbody/tr[" +(row+1)+ "]/td[1]/div/a")).click();

				}
			}

		}

		//driver.close();

	}

}
