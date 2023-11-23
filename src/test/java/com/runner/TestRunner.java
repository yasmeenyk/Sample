package com.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.base.BaseClass;
import com.reports.JVMReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

 

@RunWith(Cucumber.class)
@CucumberOptions(tags ="@Login", dryRun = false, glue = "com.stepdefenition", features = "src\\test\\resources\\Features", monochrome = true, 
plugin = {"pretty", "json:target/PW.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber-html-report" },
snippets = SnippetType.CAMELCASE)

public class TestRunner extends BaseClass {
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		JVMReport.generateJVMReport(getProjectPath()+getProperty("jsonpath"));
	}
}