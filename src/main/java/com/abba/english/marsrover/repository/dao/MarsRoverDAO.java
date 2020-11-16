package com.abba.english.marsrover.repository.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "MarsRover")
public class MarsRoverDAO {

  @Id
  @GeneratedValue
  Long id;
  int locationX;
  int locationY;
}
