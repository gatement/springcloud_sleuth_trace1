package lgh.springcloud.sleuth.trace1.controller;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/trace-1", method=RequestMethod.GET)
	public String trace() {
		log.info("=== call trace-1 ===");
		return restTemplate.getForEntity("http://trace-2/trace-2", String.class).getBody();
	}

	@RequestMapping("/first")  
    public Object first() {  
        return "first controller";  
    }  
  
    @RequestMapping("/doError")  
    public Object error() {  
        return 1 / 0;  
    }  

}
