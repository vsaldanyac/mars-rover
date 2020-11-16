package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.Service.impl.TextServiceImpl;
import com.abba.english.marsrover.exception.NoTextsToTransmitException;
import com.abba.english.marsrover.repository.TextRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.MockitoAnnotations.initMocks;

public class TextServiceTest {

  @Mock
  TextRepository textRepository;

  @InjectMocks
  TextServiceImpl textService;

  @Before
  public void setup() {
    initMocks(this);
  }

  @Test(expected = NoTextsToTransmitException.class)
  public void getRandomTextFromListWhenThereAreNoTextTest() {
    Mockito.when(textRepository.findAll()).thenReturn(new ArrayList<>());
    textService.getRandomTextFromList(textRepository.findAll());
  }
}