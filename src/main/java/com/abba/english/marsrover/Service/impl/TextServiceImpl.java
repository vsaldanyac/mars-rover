package com.abba.english.marsrover.Service.impl;

import com.abba.english.marsrover.Service.TextService;
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

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for texts
 * @author VSaldanya
 */
@Service
public class TextServiceImpl implements TextService {

  private static final Logger LOG = LoggerFactory.getLogger(TextServiceImpl.class);

  TextRepository textRepository;

  @Autowired
  public TextServiceImpl(final TextRepository textRepository) {
    this.textRepository = textRepository;

  }

  /**
   * Save a text on database
   * @param textDAO text to be saved
   * @return the data access object with the given text
   */
  @Override
  public TextDAO saveTextDAO(TextDAO textDAO) {
    TextDAO insertedTextDAO;
    try {
      insertedTextDAO = textRepository.save(textDAO);
    } catch (DataIntegrityViolationException e) {
      insertedTextDAO = textDAO;
      LOG.info(String.format("This text [%s] still in DB", textDAO.getText()));
    }
    return insertedTextDAO;
  }

  /**
   * Retrieve all the texts from database
   * @return a list of dao texts
   */
  @Override
  public List<TextDAO> findAllText() {
    return textRepository.findAll();
  }

  /**
   * method that gets randomly one text from a given list
   * @param texts list with texts
   * @return text to be gransmitted
   * @throws NoTextsToTransmitException if there are an empty list
   */
  @Override
  public String getRandomTextFromList(List<TextDAO> texts) throws NoTextsToTransmitException {
    if (texts.size() == 0) {
      throw new NoTextsToTransmitException();
    }
    return texts.get(ThreadLocalRandom.current().nextInt(0, texts.size())).getText();
  }
}
