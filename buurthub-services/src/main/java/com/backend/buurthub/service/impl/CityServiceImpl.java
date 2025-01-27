package com.backend.buurthub.service.impl;

import com.backend.buurthub.dto.CityDto;
import com.backend.buurthub.entity.City;
import com.backend.buurthub.exception.ResourceNotFoundException;
import com.backend.buurthub.mapper.CityMapper;
import com.backend.buurthub.repository.CityRepository;
import com.backend.buurthub.service.ICityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CityServiceImpl implements ICityService {

  private final CityRepository cityRepository;

  @Override
  public void createCity(CityDto cityDto) {
    City city = CityMapper.mapToCity(cityDto, new City());
    cityRepository.save(city);
  }

  @Override
  public CityDto fetchCity(String cityName) {
    City city =
        cityRepository
            .findByCityName(cityName)
            .orElseThrow(() -> new ResourceNotFoundException("City", "cityName", cityName));
    return CityMapper.mapToCityDto(city, new CityDto());
  }

  @Override
  public boolean updateCity(CityDto cityDto) {
    City city =
        cityRepository
            .findByCityName(cityDto.getCityName())
            .orElseThrow(
                () -> new ResourceNotFoundException("City", "cityName", cityDto.getCityName()));
    CityMapper.mapToCity(cityDto, city);
    cityRepository.save(city);
    return true;
  }

  @Override
  public boolean deleteCity(String cityName) {
    City city =
        cityRepository
            .findByCityName(cityName)
            .orElseThrow(() -> new ResourceNotFoundException("City", "cityName", cityName));
    cityRepository.delete(city);
    return true;
  }
}
