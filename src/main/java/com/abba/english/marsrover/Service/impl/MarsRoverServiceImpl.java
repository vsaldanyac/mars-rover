package com.abba.english.marsrover.Service.impl;

import com.abba.english.marsrover.Service.MarsRoverService;
import com.abba.english.marsrover.Service.TextService;
import com.abba.english.marsrover.domain.MarsRover;
import com.abba.english.marsrover.domain.Mover;
import com.abba.english.marsrover.domain.mapper.MarsRoverMapper;
import com.abba.english.marsrover.exception.NoTextsToTransmitException;
import com.abba.english.marsrover.repository.MarsRoverRepository;
import com.abba.english.marsrover.repository.dao.MarsRoverDAO;
import com.abba.english.marsrover.repository.dao.TextDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * Service to encapsulate the link between DAO and controller and to have business logic for mars driver
 * @author VSaldanya
 */
@Service
public class MarsRoverServiceImpl implements MarsRoverService {

  MarsRoverMapper marsRoverMapper = MarsRoverMapper.INSTANCE;

  TextService textService;

  MarsRoverRepository marsRoverRepository;

  @Autowired
  public MarsRoverServiceImpl(final TextService textService, final MarsRoverRepository marsRoverRepository) {
    this.textService = textService;
    this.marsRoverRepository = marsRoverRepository;
  }

  /**
   * This method stops the mars rover and charge its batteries
   * @param id mars rover id
   * @return the message as the command it's received ok
   */
  @Override
  public String chargeBatteries(Long id) {
    return marsRoverMapper.map(getMarsRover(id)).chargeBatteries();
  }

  /**
   * This method allows to move the mars rover
   * @param id  mars rover id
   * @param distance distance in meters to go through
   * @param angle angle in degrees for the direction
   * @return the mars rover object with the new position
   */
  @Override
  public MarsRover move(Long id, int distance, int angle) {
    Mover mover = new Mover();
    MarsRover marsRover = marsRoverMapper.map(getMarsRover(id));
    marsRover.move(mover.moveMarsRover(marsRover.getLocation(), distance, angle));
    marsRoverRepository.save(marsRoverMapper.map(marsRover));
    return marsRover;
  }

  /**
   * Method to transmit a given text
   * @param id mars rover id
   * @param text given text
   * @return the message as the command it's received ok
   */
  @Override
  public String transmitText(Long id, String text) {
    TextDAO textDAO = new TextDAO();
    textDAO.setText(text);
    MarsRover marsRover = marsRoverMapper.map(getMarsRover(id));
    marsRover.transmitText(text);
    return textService.saveTextDAO(textDAO).getText();
  }

  /**
   * Method to transmit a random text loaded from database
   * @param id mars rover id
   * @return the text that the mars rover has transmitted
   * @throws NoTextsToTransmitException If there are no texts to choose, this exception will throw
   */
  @Override
  public String transmitRandomText(Long id) throws NoTextsToTransmitException {
    String textToTransmit = textService.getRandomTextFromList(textService.findAllText());
    MarsRover marsRover = marsRoverMapper.map(getMarsRover(id));
    marsRover.transmitText(textToTransmit);
    return textToTransmit;
  }

  /**
   * Method to retrieve from DB the mars rover
   * @param id mars rover id
   * @return the mars Rover data access object
   */
  private MarsRoverDAO getMarsRover(Long id) {
    Optional<MarsRoverDAO> optionalMarsRover = marsRoverRepository.findById(id);
    return optionalMarsRover.orElseGet(MarsRoverDAO::new);
  }
}
