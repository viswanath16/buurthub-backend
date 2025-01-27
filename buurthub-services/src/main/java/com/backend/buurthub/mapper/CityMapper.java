package com.backend.buurthub.mapper;

import com.backend.buurthub.dto.CityDto;
import com.backend.buurthub.entity.City;

public class CityMapper {

  public static CityDto mapToCityDto(City city, CityDto cityDto) {
    cityDto.setCityName(city.getCityName());
    return cityDto;
  }

  public static City mapToCity(CityDto cityDto, City city) {
    city.setCityName(cityDto.getCityName());
    return city;
  }
}
