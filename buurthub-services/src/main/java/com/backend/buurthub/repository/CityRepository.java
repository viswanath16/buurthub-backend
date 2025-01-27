package com.backend.buurthub.repository;

import com.backend.buurthub.entity.City;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

  Optional<City> findByCityName(String cityName);

  @Transactional
  @Modifying
  void deleteByCityName(String cityName);
}
