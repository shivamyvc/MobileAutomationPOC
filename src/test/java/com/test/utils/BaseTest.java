package com.test.utils;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.drivers.DriverManager;

public class BaseTest {
	@BeforeSuite(alwaysRun = true)
	public void testSuiteSetup() {
		System.out.println("setting up suites report paths cretating report instances");
		
	}
	
	@BeforeMethod(alwaysRun = true)
	public void testMethodSetup() {
		System.out.println("setting up Drivers");
		DriverManager.createDriver("andrOid");
		
	}
	

	@AfterMethod(alwaysRun = true)
	public void testTearDown() {
		System.out.println("Quiting driver, clearing temp files");
		DriverManager.quitDriver();
	}
	
	
	@AfterSuite(alwaysRun = true)
	public void testSuiteTeardown() {
		System.out.println("Clearing files saving report instance");
		
	}

}
