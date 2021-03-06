package com.retrotax.test.web.controllers;

import com.retrotax.test.web.config.TestConfig;
import com.retrotax.test.web.service.TestResult;
import com.retrotax.test.web.service.TestingService;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private TestingService testingService;

    @RequestMapping(value="/api", method = RequestMethod.GET)
    public @ResponseBody String test() {
        return "hi";
    }
    
    @RequestMapping(value = "/test", consumes="application/json", method = RequestMethod.POST)
    public @ResponseBody TestResult runTests(@RequestBody List<TestConfig> seleniumTests) {
        System.out.println("test");
//        return "super";
        return testingService.runTests(seleniumTests);
    }
    
}
