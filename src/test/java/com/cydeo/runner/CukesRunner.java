package com.cydeo.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {
                "json:target/cucumber.json",
                "html:target/cucumber-report.html",
                "rerun:target/rerun.txt" ,
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",

        },
        features = "src/test/resources/features" ,
        glue = "com/cydeo/steps",
        dryRun =false,
        tags = "@us01",
        publish = true
)
public class CukesRunner {

}




