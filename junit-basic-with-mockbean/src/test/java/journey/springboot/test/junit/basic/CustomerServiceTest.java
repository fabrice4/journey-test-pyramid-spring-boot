package journey.springboot.test.junit.basic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    private CustomerService subject;

    @MockBean
    private CustomerRepository repositoryMock;

    @Test
    public void isAdult() {
        given(this.repositoryMock.findById(5L)).willReturn(
                Optional.of(new Customer("john", "barr", 25)));

        assertThat(subject.isAdult(5L),is(true));
    }
}