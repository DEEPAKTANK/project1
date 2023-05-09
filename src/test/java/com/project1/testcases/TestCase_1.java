package com.project1.testcases;

import org.testng.annotations.Test;

import com.framework.baseclass.TestBase;
import com.project1.pages.Homepage;

public class TestCase_1 extends TestBase {
	@Test
	public void testCase_task() {
	    log.info("Test case started- Task ");
		home=new Homepage(driver);
		home.clickTasks();
	    log.info("Testcase ended- Task ");

	}

}
