package com.pagemanager;

import com.base.BaseClass;
import com.pages.LoginPages;

public class PageObjectManager extends BaseClass {
	private LoginPages loginpages;
	
	public LoginPages getLoginPages() {
		return (loginpages == null)? loginpages= new LoginPages(page):loginpages;
	}
}
