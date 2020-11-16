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

@Service
public class TextServiceImpl implements TextService {

  private static final Logger LOG = LoggerFactory.getLogger(TextServiceImpl.class);

  TextRepository textRepository;

  @Autowired
  public TextServiceImpl(final TextRepository textRepository) {
    this.textRepository = textRepository;

  }

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

  @Override
  public List<TextDAO> findAllText() {
    return textRepository.findAll();
  }

  @Override
  public String getRandomTextFromList(List<TextDAO> texts) throws NoTextsToTransmitException {
    if (texts.size() == 0) {
      throw new NoTextsToTransmitException();
    }
    return texts.get(ThreadLocalRandom.current().nextInt(0, texts.size())).getText();
  }
}
