import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:/Users/jayan/OneDrive/Documents/Automation Testing/chromedriver-win64/chromedriver.exe"); // Set path for ChromeDriver
        WebDriver driver = new ChromeDriver(); // Initialize ChromeDriver

       
        driver.get("https://www.bxlend.com");  // Open the URL
        driver.manage().window().maximize();

        
        WebElement marketLink = driver.findElement(By.xpath("//a[@href='/market']")); // Select Market page from navigation
        marketLink.click();
                 
        WebElement assetList = driver.findElement(By.xpath("//table[@class='table table-borderless mt-5']")); // Check the listed assets on market page

        if (assetList.isDisplayed()) 
        	{
            	System.out.println("List of assets is displayed on the Market page.");
        	} 
        else 	
        	{
        		System.out.println("List of assets is not displayed on the Market page.");
        	}

        				// In the search bar on the market page, enter names of assets
      
        WebElement searchInput = driver.findElement(By.xpath("//input[@placeholder='Search coin']"));

        String[] assetNames = {"AVAX", "FTM", "USDT"}; 	// Replace with other asset names
        for (String assetName : assetNames) 
        	{
            	searchInput.clear();
            	searchInput.sendKeys(assetName);

            	try {
            			Thread.sleep(5000);
            		} 
            	catch(InterruptedException e) 
            		{
            			e.printStackTrace();
            		}

      
        	}

       driver.quit(); //Close the browser window
    }
}
