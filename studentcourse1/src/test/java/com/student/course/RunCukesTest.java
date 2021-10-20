/*
 * Copyright (c) 2021
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.util.SocketUtils;

/**
 * JUnit runner for Cucumber. This is the class we should run to execute the Cucumber tests.
 *
 * @author 
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		junit = { "--filename-compatible-names" },
		plugin = {"html:build/reports/bdd", "json:build/reports/bdd/featureTests.json"},
		features = {"src/test/java/com/lmig/standalonepurges/feature/"})
@SuppressWarnings("PMD.ClassNamingConventions")
public final class RunCukesTest {

	private RunCukesTest() {
	}

	@BeforeClass
	public static void beforeClass() {
		int port = SocketUtils.findAvailableTcpPort();
		System.setProperty("wiremock.server.port", String.valueOf(port));
	}
}

