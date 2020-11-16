package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.Service.impl.MarsRoverServiceImpl;
import com.abba.english.marsrover.repository.MarsRoverRepository;
import com.abba.english.marsrover.repository.dao.MarsRoverDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.MockitoAnnotations.initMocks;

public class MarsRoverServiceTest {

  @Mock
  TextService textService;

  @Mock
  MarsRoverRepository marsRoverRepository;

  @InjectMocks
  MarsRoverServiceImpl marsRoverService;

  @Before
  public void setup() {
    initMocks(this);
  }

  @Test
  public void shouldReturnMoveMessageOnOrderMoveTest() {
    Mockito.when(marsRoverRepository.findById(any(Long.class))).thenReturn(Optional.of(new MarsRoverDAO()));
    Assert.assertEquals(marsRoverService.move(1L, 0, 0), "Movement order received");
  }

  @Test
  public void shouldReturnChargeBatteriesMessageOnOrderChargeTest() {
    Mockito.when(marsRoverRepository.findById(any(Long.class))).thenReturn(Optional.of(new MarsRoverDAO()));
    Assert.assertEquals(marsRoverService.chargeBatteries(1L), "Charge Batteries order received");
  }

}