package com.abba.english.marsrover.controllers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MarsRoverControllerTest {


  @Autowired
  private MockMvc mockMvc;

  @Before
  public void setup() {
    initMocks(this);
  }

  @Test
  public void shouldExistEndpointForMovingTest() throws Exception {
    this.mockMvc.perform(put("/v1/mars-rover/move"))
        .andExpect(status().is2xxSuccessful()
        );
  }

  @Test
  public void shouldExistEndpointForChargeBatteriesTest() throws Exception {
    this.mockMvc.perform(put("/v1/mars-rover/charge"))
        .andExpect(status().is2xxSuccessful()
        );
  }

  @Test
  public void shouldExistEndpointForTransmitText() throws Exception {
    this.mockMvc.perform(put("/v1/mars-rover/transmit")
        .param("text", "First text to transmit"))
        .andExpect(status().is2xxSuccessful()
        );
  }

  @Test
  public void shouldReturnMessageChargingBatteriesTest() throws Exception {
    ResultActions resultActions = this.mockMvc.perform(put("/v1/mars-rover/charge"))
        .andExpect(status().is2xxSuccessful()
        );
    String resultString = resultActions.andReturn().getResponse().getContentAsString();
    JacksonJsonParser jsonParser = new JacksonJsonParser();
    Assert.assertEquals(jsonParser.parseMap(resultString).get("message").toString(), "Charge Batteries order received");
  }

  @Test
  public void shouldReturnMessageMovementTest() throws Exception {
    ResultActions resultActions = this.mockMvc.perform(put("/v1/mars-rover/move"))
        .andExpect(status().is2xxSuccessful()
        );
    String resultString = resultActions.andReturn().getResponse().getContentAsString();
    JacksonJsonParser jsonParser = new JacksonJsonParser();
    Assert.assertEquals(jsonParser.parseMap(resultString).get("message").toString(), "Movement order received");
  }

  @Test
  public void shouldReturnTextTransmitTest() throws Exception {
    ResultActions resultActions = this.mockMvc.perform(put("/v1/mars-rover/transmit")
        .param("text", "First text to transmit"))
        .andExpect(status().is2xxSuccessful()
        );
    String resultString = resultActions.andReturn().getResponse().getContentAsString();
    JacksonJsonParser jsonParser = new JacksonJsonParser();
    Assert.assertEquals(jsonParser.parseMap(resultString).get("message").toString(), "First text to transmit");
  }

  @Test
  public void shouldExistEndpointForTransmitRandomText() throws Exception {
    this.mockMvc.perform(put("/v1/mars-rover/transmit")
        .param("text", "First text to transmit"))
        .andExpect(status().is2xxSuccessful()
        );
    this.mockMvc.perform(get("/v1/mars-rover/transmit-random"))
        .andExpect(status().is2xxSuccessful()
        );
  }

}