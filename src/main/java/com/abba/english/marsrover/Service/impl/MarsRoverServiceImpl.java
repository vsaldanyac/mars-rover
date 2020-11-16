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

  @Override
  public String chargeBatteries(Long id) {
    Optional<MarsRoverDAO> marsRover = getMarsRover(id);
    return marsRoverMapper.map(marsRover.get()).chargeBatteries();
  }

  @Override
  public String move(Long id, int distance, int angle) {
    Mover mover = new Mover();
    Optional<MarsRoverDAO> marsRoverDAO = getMarsRover(id);
    MarsRover marsRover = marsRoverMapper.map(marsRoverDAO.get());
    return marsRover.move(mover.moveMarsRover(marsRover.getLocation(), distance, angle));
  }

  @Override
  public String transmitText(Long id, String text) {
    TextDAO textDAO = new TextDAO();
    textDAO.setText(text);
    Optional<MarsRoverDAO> marsRoverDAO = getMarsRover(id);
    MarsRover marsRover = marsRoverMapper.map(marsRoverDAO.get());
    marsRover.transmitText(text);
    return textService.saveTextDAO(textDAO).getText();
  }

  @Override
  public String transmitRandomText(Long id) throws NoTextsToTransmitException {
    String textToTransmit = textService.getRandomTextFromList(textService.findAllText());
    Optional<MarsRoverDAO> marsRoverDAO = getMarsRover(id);
    MarsRover marsRover = marsRoverMapper.map(marsRoverDAO.get());
    marsRover.transmitText(textToTransmit);
    return textToTransmit;
  }

  private Optional<MarsRoverDAO> getMarsRover(Long id) {
    return marsRoverRepository.findById(id);
  }
}
