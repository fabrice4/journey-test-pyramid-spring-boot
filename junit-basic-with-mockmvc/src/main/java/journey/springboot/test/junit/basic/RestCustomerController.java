package journey.springboot.test.junit.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class RestCustomerController {

    @Autowired
    private CustomerService service;

    @RequestMapping("/customer/all")
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> customers = service.findAll();
        if (customers == null || customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

}