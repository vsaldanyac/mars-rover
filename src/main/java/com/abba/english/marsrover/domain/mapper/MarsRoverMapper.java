package com.abba.english.marsrover.domain.mapper;

import com.abba.english.marsrover.domain.MarsRover;
import com.abba.english.marsrover.repository.dao.MarsRoverDAO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MarsRoverMapper {

  MarsRoverMapper INSTANCE = Mappers.getMapper(MarsRoverMapper.class);

  @Mapping(target = "location", expression="java(new com.abba.english.marsrover.domain.Location(marsRoverDAO.getLocationX(), marsRoverDAO.getLocationY()))")
  MarsRover map(MarsRoverDAO marsRoverDAO);
}
