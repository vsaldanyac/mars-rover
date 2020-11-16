package com.abba.english.marsrover.Service.impl;

import com.abba.english.marsrover.Service.MarsRoverService;
import com.abba.english.marsrover.domain.MarsRover;
import com.abba.english.marsrover.domain.Mover;
import com.abba.english.marsrover.exception.NoTextsToTransmitException;
import com.abba.english.marsrover.repository.TextRepository;
import com.abba.english.marsrover.repository.dao.TextDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class MarsRoverServiceImpl implements MarsRoverService {

  private static final Logger LOG = LoggerFactory.getLogger(MarsRoverServiceImpl.class);

  TextRepository textRepository;

  MarsRover marsRover = new MarsRover();

  @Autowired
  public MarsRoverServiceImpl(final TextRepository textRepository) {
    this.textRepository = textRepository;
  }

  @Override
  public String chargeBatteries(Long id) {
    return marsRover.chargeBatteries();
  }

  @Override
  public String move(Long id, int distance, int angle) {
    Mover mover = new Mover();
    return marsRover.move(mover.moveMarsRover(marsRover.getLocation(), distance, angle));
  }

  @Override
  public String transmitText(Long id, String text) {
    TextDAO textDAO = new TextDAO();
    textDAO.setText(text);
    marsRover.transmitText(text);
    return saveTextDAO(textDAO).getText();
  }

  @Override
  public String transmitRandomText(Long id) throws NoTextsToTransmitException {
    String textToTransmit = getRandomTextFromList(findAllText());
    marsRover.transmitText(textToTransmit);
    return textToTransmit;
  }

  private TextDAO saveTextDAO(TextDAO textDAO) {
    TextDAO insertedTextDAO;
    try {
      insertedTextDAO = textRepository.save(textDAO);
    } catch (DataIntegrityViolationException e) {
      insertedTextDAO = textDAO;
      LOG.info(String.format("This text [%s] still in DB", textDAO.getText()));
    }
    return insertedTextDAO;
  }

  private List<TextDAO> findAllText() {
    return textRepository.findAll();
  }

  private String getRandomTextFromList(List<TextDAO> texts) throws NoTextsToTransmitException {
    if (texts.size() == 0) {
      throw new NoTextsToTransmitException();
    }
    return texts.get(ThreadLocalRandom.current().nextInt(0, texts.size())).getText();
  }
}
