package com.backend.buurthub.service;

import com.backend.buurthub.dto.CityDto;

public interface ICityService {

  /**
   * @param cityDto - CustomerDto Object
   */
  void createCity(CityDto cityDto);

  /**
   * @param cityName - Input Mobile Number
   * @return City Details based on a given cityName
   */
  CityDto fetchCity(String cityName);

  /**
   * @param cityDto - CustomerDto Object
   * @return boolean indicating if the update of City details is successful or not
   */
  boolean updateCity(CityDto cityDto);

  /**
   * @param cityName - Input City Name
   * @return boolean indicating if the delete of City details is successful or not
   */
  boolean deleteCity(String cityName);
}
