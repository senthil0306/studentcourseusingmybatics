/*
 * Copyright (c) 2020, Liberty Mutual
 * Proprietary and Confidential
 * All Rights Reserved
 */

package com.student.course.feature;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

/**
 * Empty Step Definition class used to configure the Spring Boot Application
 * Context for our Cucumber tests, which will start our full Spring Boot app.
 *
 * The Spring test configuration given by the annotations below can only be
 * applied to one Step Definition class, so we've chosen to put them here;
 * note that if you remove this class, you will need to move these annotations
 * to a different Step Definition class if you plan to run your full Spring
 * Boot app during your Cucumber tests.
 *
 * See https://github.com/cucumber/cucumber-jvm/issues/1390
 *
 * @author DNA Generator, version 1.87.38
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({ "mock" })
@DirtiesContext
public class CucumberSpringBootAppConfig implements io.cucumber.java8.En {
}

