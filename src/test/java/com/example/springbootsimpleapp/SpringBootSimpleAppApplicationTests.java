package com.example.springbootsimpleapp;

import com.example.springbootsimpleapp.controller.PersonController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class SpringBootSimpleAppApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonController personController;

    @Test
    public void check_controllerIsNotNull() throws Exception
    {
       assertThat(personController).isNotNull();
    }

    @Test
    public void findPersonById() throws Exception
    {
        this.mvc.perform(MockMvcRequestBuilders
                .get("/persons/{id}", "169dbd2e-7c36-11ed-a1eb-0242ac120002")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Rohan"))
                .andExpect(jsonPath("$.lastName").value("Montes"))
                .andExpect(jsonPath("$.age").value(23));
    }

    @Test
    public void findPersonById_null() throws Exception
    {
        this.mvc.perform(MockMvcRequestBuilders
                .get("/persons/{id}", "342432-7c36-11ed-a1eb-0242ac120002")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName").doesNotExist());
    }

    @Test
    public void findAllPersons() throws Exception {
        this.mvc.perform(get("/persons"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()", is(5)));
    }


}
