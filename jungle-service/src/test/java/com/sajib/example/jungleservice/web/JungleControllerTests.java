package com.sajib.example.jungleservice.web;

import com.sajib.example.jungleservice.JungleserviceApplication;
import com.sajib.example.jungleservice.service.JungleService;
import com.sajib.example.jungleservice.web.model.AnimalDTO;
import com.sajib.example.jungleservice.web.model.BirdDTO;
import com.sajib.example.jungleservice.web.model.JungleResponse;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by sajib on 1/26/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = JungleserviceApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:bootstrap.properties")
public class JungleControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JungleService jungleService;

    private final String EXPECTED_JSON_RESPONSE = "{\"animalDTOList\":[{\"name\":\"Tiger\",\"description\":\"Largest cat species\"}," +
            "{\"name\":\"Lion\",\"description\":\"King of jungle\"}]," +
            "\"birdDTOList\":[{\"name\":\"Eagle\",\"description\":\"Birds of prey\"}," +
            "{\"name\":\"Kingfisher\",\"description\":\"Brightly colored birds\"}]}";

    @Before
    public void setup() {
        List<AnimalDTO> animalDTOList = Arrays.asList(new AnimalDTO("Tiger", "Largest cat species"),
                new AnimalDTO("Lion", "King of jungle"));
        List<BirdDTO> birdDTOList = Arrays.asList(new BirdDTO("Eagle", "Birds of prey"),
                new BirdDTO("Kingfisher", "Brightly colored birds"));
        JungleResponse jungleResponse = new JungleResponse();
        jungleResponse.setAnimalDTOList(animalDTOList);
        jungleResponse.setBirdDTOList(birdDTOList);

        when(jungleService.getAllSpecies()).thenReturn(jungleResponse);
    }

    @Test
    public void getAllSpecies_GivenGetRequest_ThenListAllSpecies() throws Exception {
        ResultActions result = mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.animalDTOList.[0].name", is("Tiger")))
                .andExpect(jsonPath("$.animalDTOList.[1].name", is("Lion")))
                .andExpect(jsonPath("$.birdDTOList.[0].name", is("Eagle")))
                .andExpect(jsonPath("$.birdDTOList.[1].name", is("Kingfisher")))
                .andExpect(content().json(EXPECTED_JSON_RESPONSE));
    }
}
