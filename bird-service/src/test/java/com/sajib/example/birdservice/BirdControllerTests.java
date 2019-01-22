package com.sajib.example.birdservice;

import com.sajib.example.birdservice.model.Bird;
import com.sajib.example.birdservice.service.BirdService;
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

/**
 * Created by sajib on 1/22/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = BirdserviceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:bootstrap.properties")
public class BirdControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BirdService birdService;

    final String EXPECTED_JSON_RESPONSE = "[{\"name\":\"Eagle\",\"description\":\"Birds of prey\"}," +
            "{\"name\":\"Kingfisher\",\"description\":\"Brightly colored birds\"}]";

    @Before
    public void setup() {
        List<Bird> birdList = Arrays.asList(new Bird("Eagle", "Birds of prey"),
                new Bird("Kingfisher", "Brightly colored birds"));
        when(birdService.getAllBirds()).thenReturn(birdList);
    }

    @Test
    public void getAllBirds_GivenGetRequest_ThenListAllBirds() throws Exception {
        ResultActions resultActions = mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name", is("Eagle")))
                .andExpect(jsonPath("$[1].name", is("Kingfisher")))
                .andExpect(content().json(EXPECTED_JSON_RESPONSE));
    }

}
