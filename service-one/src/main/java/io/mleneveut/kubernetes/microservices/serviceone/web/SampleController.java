package io.mleneveut.kubernetes.microservices.serviceone.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Sample controllers with example methods
 */
@RestController
@RequestMapping("/")
@Api(tags = "ServiceOne")
public class SampleController {
    private static final Logger log = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    @ApiOperation(value = "infos", notes = "Get info")
    @HystrixCommand(groupKey = "service-one", commandKey = "service-one.info", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })
    public ResponseEntity<String> getInfos() throws UnknownHostException {
        String response = InetAddress.getLocalHost().toString();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/second")
    @ApiOperation(value = "httpCall", notes = "Send a direct HTTP message to another microservice")
    public ResponseEntity<String> httpCall() throws UnknownHostException {
        String response = InetAddress.getLocalHost().toString();
        //Call the service "service-two" thanks to Kubernetes DNS feature
        response += ", second : " + restTemplate.getForObject("http://service-two", String.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}