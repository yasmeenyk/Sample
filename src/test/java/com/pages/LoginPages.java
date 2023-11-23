package com.pages;

import com.base.BaseClass;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LoginPages extends BaseClass{
//	    private  Page page;
	    private final Locator loginbtn;
	    private final Locator usernametxt;
	    private final Locator passwordtxt;
	    private final Locator loginClickBtn;
	    private final Locator usernameValue;
	    private final Locator ErrorValue;
	    private final Locator LoginSuccMsg;
	    private final Locator LoginErrorMsg;
	    
		public LoginPages(Page page) {
			this.page = page;
			this.loginbtn = page.locator("//div[contains(text(), 'Login')]");
			this.usernametxt = page.locator("input[type='text']");
			this.passwordtxt = page.locator("input[type='password']");
			this.loginClickBtn = page.locator("//button[@type='button']//span");
			this.usernameValue = page.locator("//div[contains(text(),'yasmeen')]");
			this.ErrorValue = page.locator("//div[contains(text(),'The')]");
			this.LoginSuccMsg =page.locator("//div[contains(text(),'Demo user')]");
			this.LoginErrorMsg = page.locator("//div[contains(text(),'The')]");
		}
	    
  
	    
	    public void login(String username, String password) {
	    	loginbtn.click();
	    	usernametxt.fill(username);
	    	passwordtxt.fill(password);	
	    }
	    
	    public void clickLogin() {
	    	loginClickBtn.click();
	    }
	    
	    public String succMsg() {
	    	String textContent = LoginSuccMsg.textContent().trim();
	    	System.out.println(textContent);
			return textContent;
	    }
	    
	    public String errorMsg() {
	    	String trim = LoginErrorMsg.textContent().trim();
	    	System.out.println(trim);
			return trim;
	    }
	}
	