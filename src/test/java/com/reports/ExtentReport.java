//package com.reports;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import net.bytebuddy.asm.Advice.Enter;
//
//public class ExtentReport {
//	private ExtentReports extent;
//	private ExtentTest test;
//	private ExtentSparkReporter sparkReporter;
//
//	public ExtentReport() {
//		ExtentReports extent = new ExtentReports();
//		sparkReporter = new ExtentSparkReporter("extent-report.html");
//		extent.attachReporter(sparkReporter);
//	}
//
//	public void captureScreenshot() {
//		extent.createTest("ScreenCapture").addScreenCaptureFromPath("extent_report.png")
//				.pass(MediaEntityBuilder.createScreenCaptureFromPath("extent_report.png").build());
//	}
//
//	public void createTest(String testName) {
//		test = extent.createTest(testName);
//	}
//
//	public void logInfo(String message) {
//		test.log(Status.INFO, message);
//	}
//
//	public void logPass(String message) {
//		test.log(Status.PASS, message);
//	}
//
//	public void logFaill(String message) {
//		test.log(Status.FAIL, message);
//	}
//
//	public void logSkip(String message) {
//		test.log(Status.SKIP, message);
//	}
//
//	public void flushReport() {
//		extent.flush();
//	}
//
//}
