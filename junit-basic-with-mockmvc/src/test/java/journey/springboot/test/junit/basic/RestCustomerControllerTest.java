package journey.springboot.test.junit.basic;

import journey.springboot.test.junit.basic.Customer;
import journey.springboot.test.junit.basic.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class RestCustomerControllerTest {

    @Autowired
    private WebApplicationContext webContext;

    @MockBean CustomerService service;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc= MockMvcBuilders
                .webAppContextSetup(webContext)
                .build();
    }

    @Test
    public void test_get_all_success() throws Exception {
        List<Customer> customers = Arrays.asList(
                new Customer("mike","michell",29),
                new Customer("suzy","baker",45));
        given(service.findAll()).willReturn(customers);
        mockMvc.perform(get("/customer/all"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(jsonPath("$[0].firstName", is("mike")));
    }

    @Test
    public void test_404_url() throws Exception {
        mockMvc.perform(get("/customer/unknown"))
                .andExpect(status().isNotFound());
    }

}