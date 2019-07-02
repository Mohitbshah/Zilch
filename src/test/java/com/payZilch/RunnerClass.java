package com.payZilch;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Welcome on 02/07/2019.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = ".", tags = "@test",dryRun = false, format = {"pretty","html:target/cukeReport"})


public class RunnerClass {
}
