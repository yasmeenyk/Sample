import java.nio.file.Paths;

import com.base.BaseClass;
import com.microsoft.playwright.*;
//import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class Sample extends BaseClass{
	public static void main(String[] args) throws InterruptedException {
		
			Playwright playwright = Playwright.create();

			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

			BrowserContext browserContext = browser.newContext();

			Page page = browserContext.newPage();

			page.navigate("https://demo.cyclos.org/ui/home");
			
//			page.waitForSelector("div:text('Login')").click();

			page.locator("//div[contains(text(), 'Login')]").click();

			page.locator("input[type='text']").fill("yasmeen");

			page.locator("input[type='password']").fill("Yasmeen@123");
			

			page.click("//button[@type='button']//span");
			

			page.waitForSelector("//div[text()='Banking']").click();
			page.getByText("Show filters").click();
			
			page.screenshot(new Page.ScreenshotOptions()
				      .setPath(Paths.get("screenshot.png")));
			String byAltText = page.locator("//div[contains(text(),  'yasmeen ')]").textContent();
			System.out.println(byAltText);
			page.close();
		}
	  
		
	}



