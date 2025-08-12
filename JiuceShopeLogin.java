package JuiceShop;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class JiuceShopeLogin {
	String url = "https://juice-shop.herokuapp.com/#/register";
	public static WebDriver driver;

	@FindBy(xpath = "//button//span[text()='Dismiss']")
	WebElement dismissBtn;
	@FindBy(xpath = "//input[@id='emailControl']")
	WebElement emailId;
	
	@FindBy(id="emailControl") WebElement email;
	@FindBy(id=("passwordControl")) WebElement password;
	@FindBy(id="repeatPasswordControl") WebElement repeatPassword;
	@FindBy(xpath="//*[@name='securityQuestion']") WebElement securityQues;
	@FindBy(xpath="//*[@id='mat-option-1']/span") WebElement clickSequrityQuestion;
	@FindBy(id="securityAnswerControl") WebElement sendAns;
	@FindBy(xpath="//button[@id='registerButton']//span[text()=' Register ']") WebElement register;
	@FindBy(xpath="//div[text()='Email must be unique']") WebElement errorMsg;
	@FindBy(xpath="//div[@id='alreadyACustomerLink']/a") WebElement allReadyaCustomer;
	@FindBy(id="email") WebElement emailRg;
	
	
	WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));

	public void navigate() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		driver.get(url);
		PageFactory.initElements(driver, this);
		
		try {
			//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(dismissBtn));
			
			//Thread.sleep(5000);
			System.out.println("inside register");
			dismissBtn.click();
		} catch (Exception e) {
			System.out.println("pop up not present");
			// TODO: handle exception
		}
		

	}
	
	
	public void register() {
		email.sendKeys("khushboo@gmail.com");
		System.out.println("email sent");
		wait.until(ExpectedConditions.elementToBeClickable(password));
		
		
	password.click();
	password.sendKeys("Test@1234");
	wait.until(ExpectedConditions.elementToBeClickable(repeatPassword));
	repeatPassword.sendKeys("Test@1234");
	
	securityQues.click();
	clickSequrityQuestion.click();
	wait.until(ExpectedConditions.elementToBeClickable(sendAns));
	sendAns.sendKeys("Agrawal");
	register.click();

	try {
		wait.until(ExpectedConditions.visibilityOf(errorMsg));
		allReadyaCustomer.click();
		loginPage();
		
	} catch (Exception e) {
		loginPage();
		// TODO: handle exception
	}
	
	
		
		
	}

	public void loginPage() {
		wait.until(ExpectedConditions.elementToBeClickable(emailRg));
		emailRg	.click();
		emailRg.sendKeys("khushboo@gmail.com");
		
	}
	public static void main(String[] args) throws InterruptedException {
		JiuceShopeLogin js = new JiuceShopeLogin();
		js.navigate();
		js.register();

		// TODO Auto-generated method stub

	}

}
