package com.abba.english.marsrover.repository;

import com.abba.english.marsrover.repository.dao.MarsRoverDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author VSaldanya
 */
@Repository
public interface MarsRoverRepository extends CrudRepository<MarsRoverDAO, Long> {
}
