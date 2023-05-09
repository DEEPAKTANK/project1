package com.project1.testcases;

import org.testng.annotations.Test;

import com.framework.baseclass.TestBase;

public class TestCase_3 extends TestBase{
	@Test
	public void testCase_user() {
		home.clickUsers();
	}

}
