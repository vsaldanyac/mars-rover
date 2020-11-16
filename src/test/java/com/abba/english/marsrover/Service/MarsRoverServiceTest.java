package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.Service.impl.MarsRoverServiceImpl;
import com.abba.english.marsrover.domain.MarsRover;
import com.abba.english.marsrover.exception.NoTextsToTransmitException;
import com.abba.english.marsrover.repository.TextRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.MockitoAnnotations.initMocks;

public class MarsRoverServiceTest {

  @Mock
  TextRepository textRepository;

  @InjectMocks
  MarsRoverServiceImpl marsRoverService;

  @Before
  public void setup() {
    initMocks(this);
  }

  @Test(expected = NoTextsToTransmitException.class)
  public void shouldReturnExceptionOnTransmitRandomTextWhenDontExistTest() {
    Mockito.when(textRepository.findAll()).thenReturn(new ArrayList<>());
    marsRoverService.transmitRandomText();
  }

  @Test
  public void shouldReturnMoveMessageOnOrderMoveTest() {
    Assert.assertEquals(marsRoverService.move(), "Movement order received");
  }

  @Test
  public void shouldReturnChargeBatteriesMessageOnOrderChargeTest() {
    Assert.assertEquals(marsRoverService.chargeBatteries(), "Charge Batteries order received");
  }

}