package MavenTest.EFORMS;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	
	public static final String TESTLINK_KEY = "4ebd72f18419c2c137c5219c172d28bb";
	public static final String TESTLINK_URL = "http://localhost/TestLink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TESTLINK_PROJECT_NAME = "EFormsTestProject";
	public static final String TESTLINK_PLAN_NAME = "EFormsTestPlan";
	//public static final String TESTLINK_CASE_NAME = "FirstTestCase";
	public static final String BUILD_NAME = "EFormsBuildTest";
	
	public static void updateResults (String testCaseName, String exception,String results) throws TestLinkAPIException{
		
		TestLinkAPIClient testLink = new TestLinkAPIClient(TESTLINK_KEY,TESTLINK_URL);
		testLink.reportTestCaseResult(TESTLINK_PROJECT_NAME, TESTLINK_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
		
	
	}

}
