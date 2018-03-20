package journey.springboot.test.junit.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public boolean isAdult(Long id){
        Optional<Customer> optCustomer=repository.findById(id);
        return optCustomer.filter(customer -> customer.getAge() >= 18).isPresent();
    }
}
