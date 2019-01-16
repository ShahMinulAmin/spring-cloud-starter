package com.sajib.example.animalservice;

import com.sajib.example.animalservice.model.Animal;
import com.sajib.example.animalservice.service.AnimalService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = AnimalserviceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:bootstrap.properties")
public class AnimalControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AnimalService animalService;

    final String EXPECTED_JSON_RESPONSE = "[{\"name\":\"Tiger\",\"description\":\"Largest cat species\"}, " +
            "{\"name\":\"Lion\",\"description\":\"King of jungle\"}]";

    @Before
    public void setup() {
        List<Animal> animalList = Arrays.asList(new Animal("Tiger", "Largest cat species"),
                new Animal("Lion", "King of jungle"));
        when(animalService.getAllAnimals()).thenReturn(animalList);
    }

    @Test
    public void getAllAnimals_GivenGetRequest_ThenListAllAnimals() throws Exception {
        ResultActions result = mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk()).andExpect(content().json(EXPECTED_JSON_RESPONSE))
                .andExpect(jsonPath("$[0].name", is("Tiger")))
                .andExpect(jsonPath("$[1].name", is("Lion")));
    }

}

