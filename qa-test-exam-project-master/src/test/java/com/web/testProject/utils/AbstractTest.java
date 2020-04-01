package com.web.testProject.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

/**
 * Created by RusS on 4/25/2017.
 */
@ContextConfiguration(locations = {"classpath:conf/testProjectConfig.xml"})
public class AbstractTest extends AbstractTestNGSpringContextTests {

    @Autowired
    public SpringLocomotive locomotive;

    @Autowired
    public UrlFactory urlFactory;

}
