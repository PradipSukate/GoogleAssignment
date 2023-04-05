package com.edusol.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.edusol.base.CommonMethods;


public class ExtentReporter extends CommonMethods {
	
	static ExtentSparkReporter htmlreport;
	static ExtentReports report;
	
	public static ExtentReports initReport() {
		htmlreport=new ExtentSparkReporter(homepath+"\\src\\test\\resources\\Reports\\Extentreports_"+getDateTimeinMins()+".html");
		htmlreport.config().setDocumentTitle("Execution report");
		htmlreport.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		return report;		
	}

}
