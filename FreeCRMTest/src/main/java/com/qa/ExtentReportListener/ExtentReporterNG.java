/*
 * @autor : Pushkar Gosain
 * 
 */
package com.qa.ExtentReportListener;

import java.io.File;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator
				+ "AutomationReport.html", true);

		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();

			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			
			}
		}

		extent.flush();
		extent.close();
	}

//	private void buildTestNodes(IResultMap tests, LogStatus status) {
//		ExtentTest test;
//
//		if (tests.size() > 0) {
//			for (ITestResult result : tests.getAllResults()) {
//				test = extent.startTest(result.getMethod().getMethodName());
//
//				test.setStartedTime(getTime(result.getStartMillis()));
//				test.setEndedTime(getTime(result.getEndMillis()));
//
//				for (String group : result.getMethod().getGroups())
//					test.assignCategory(group);
//
//				if (result.getThrowable() != null) {
//					test.log(status, result.getThrowable());
//				} else {
//					test.log(status, "Test " + status.toString().toLowerCase()
//							+ "ed");
//				}
//
//				extent.endTest(test);
//			}
//		}
//	}
	
	private void buildTestNodes(IResultMap tests, LogStatus status) {
        ExtentTest test;
        if (tests.size() > 0) {
            List<ITestResult> resultList = new LinkedList<ITestResult>(tests.getAllResults());
            class ResultComparator implements Comparator<ITestResult> {
                public int compare(ITestResult rT1, ITestResult rT2) {
                    return getTime(rT1.getStartMillis()).compareTo(getTime(rT2.getStartMillis()));
                }
            }
            Collections.sort(resultList , new ResultComparator ());
            for (ITestResult result : resultList) {
                test = extent.startTest(result.getMethod().getMethodName());
                //test.getTest().setDescription(result.getMethod().getDescription());
                //test.getTest().setDescription(result.getMethod().getMethodName());
                test.getTest().setStartedTime(getTime(result.getStartMillis()));
                test.getTest().setEndedTime(getTime(result.getEndMillis()));
                for(String message:Reporter.getOutput(result)){ 
                    test.log(LogStatus.INFO, message);
                }
                for (String group : result.getMethod().getGroups())
                test.assignCategory(group);
                String message = "Test " + status.toString().toLowerCase() + "ed";
                if (result.getThrowable() != null)
                message = result.getThrowable().getClass() +" : "+ result.getThrowable().getMessage();
                test.log(status, message);
                extent.endTest(test);
            }
        }
    }
	
	private Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}
}