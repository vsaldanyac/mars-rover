package com.abba.english.marsrover.Service;

import com.abba.english.marsrover.exception.NoTextsToTransmitException;
import com.abba.english.marsrover.repository.dao.TextDAO;

import java.util.List;

public interface TextService {

  TextDAO saveTextDAO(TextDAO textDAO);

  List<TextDAO> findAllText();

  String getRandomTextFromList(List<TextDAO> texts) throws NoTextsToTransmitException;
}
