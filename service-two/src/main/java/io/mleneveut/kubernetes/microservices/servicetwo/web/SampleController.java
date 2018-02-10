package io.mleneveut.kubernetes.microservices.servicetwo.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import io.mleneveut.kubernetes.microservices.servicetwo.settings.ServiceTwoSettings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Sample controllers with example methods
 */
@RestController
@RequestMapping("/")
@Api(tags = "Service two")
public class SampleController {
    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private ServiceTwoSettings settings;

    @GetMapping("/")
    @ApiOperation(value = "httpCall", notes = "Send a direct HTTP message to another microservice")
    @HystrixCommand(groupKey = "service-two", commandKey = "service-two.httpCall", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public ResponseEntity<String> infos() throws UnknownHostException {
        String response = InetAddress.getLocalHost().toString();

        return new ResponseEntity<>("String param1=" + settings.getCustomStringParam1() + ", " + response, HttpStatus.OK);
    }
}