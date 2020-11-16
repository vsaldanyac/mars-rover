package com.abba.english.marsrover.repository.dao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "Messages")
public class TextDAO {

  @Id
  @GeneratedValue
  Long id;
  @Column(nullable = false, unique = true)
  String text;

}
