package com.abba.english.marsrover.repository;

import com.abba.english.marsrover.repository.dao.TextDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author VSaldanya
 */
@Repository
public interface TextRepository extends CrudRepository<TextDAO, Long> {


  List<TextDAO> findAll();
}
