package com.abba.english.marsrover.Service.impl;

import com.abba.english.marsrover.Service.MarsRoverService;
import com.abba.english.marsrover.Service.TextService;
import com.abba.english.marsrover.domain.Location;
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
    return marsRoverMapper.map(getMarsRover(id)).chargeBatteries();
  }

  @Override
  public MarsRover move(Long id, int distance, int angle) {
    Mover mover = new Mover();
    MarsRover marsRover = marsRoverMapper.map(getMarsRover(id));
    marsRover.move(mover.moveMarsRover(marsRover.getLocation(), distance, angle));
    marsRoverRepository.save(marsRoverMapper.map(marsRover));
    return marsRover;
  }

  @Override
  public String transmitText(Long id, String text) {
    TextDAO textDAO = new TextDAO();
    textDAO.setText(text);
    MarsRover marsRover = marsRoverMapper.map(getMarsRover(id));
    marsRover.transmitText(text);
    return textService.saveTextDAO(textDAO).getText();
  }

  @Override
  public String transmitRandomText(Long id) throws NoTextsToTransmitException {
    String textToTransmit = textService.getRandomTextFromList(textService.findAllText());
    MarsRover marsRover = marsRoverMapper.map(getMarsRover(id));
    marsRover.transmitText(textToTransmit);
    return textToTransmit;
  }

  private MarsRoverDAO getMarsRover(Long id) {
    Optional<MarsRoverDAO> optionalMarsRover = marsRoverRepository.findById(id);
    return optionalMarsRover.orElseGet(MarsRoverDAO::new);
  }
}
