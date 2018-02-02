package org.huseyin.unitconverter.bdd.config;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(AcceptanceTestConfiguration.class)
public abstract class SpringAcceptanceTest {

    @LocalServerPort
    private int port;

    @Autowired
    protected WebDriver driver;

    public String getApplicationURL() {
        return "http://localhost:" + port ;
    }
}