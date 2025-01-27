package com.backend.buurthub.repository;

import com.backend.buurthub.entity.Event;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

  Optional<Event> findByTitle(String title);

  @Transactional
  @Modifying
  void deleteByTitle(String title);
}
