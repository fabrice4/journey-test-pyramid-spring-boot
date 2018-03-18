package journey.springboot.test.junit.basic.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class RestHelloController {

    @RequestMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

}