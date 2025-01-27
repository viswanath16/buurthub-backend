package com.backend.buurthub.service.impl;

import com.backend.buurthub.dto.EventDto;
import com.backend.buurthub.entity.Event;
import com.backend.buurthub.mapper.EventMapper;
import com.backend.buurthub.repository.EventRepository;
import com.backend.buurthub.service.IEventService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventServiceImpl implements IEventService {

  private final EventRepository eventRepository;

  public EventServiceImpl(EventRepository eventRepository) {
    this.eventRepository = eventRepository;
  }

  @Override
  public void createEvent(EventDto eventDto) {
    Event event = EventMapper.mapToEvent(eventDto, new Event());
    eventRepository.save(event);
  }

  @Override
  public EventDto fetchEvent(String title) {
    Optional<Event> eventOptional = eventRepository.findByTitle(title);
    if (eventOptional.isPresent()) {
      return EventMapper.mapToEventDto(eventOptional.get(), new EventDto());
    }
    return null;
  }

  @Override
  public boolean updateEvent(EventDto eventDto) {
    Optional<Event> eventOptional = eventRepository.findByTitle(eventDto.getTitle());
    if (eventOptional.isPresent()) {
      Event event = EventMapper.mapToEvent(eventDto, eventOptional.get());
      eventRepository.save(event);
      return true;
    }
    return false;
  }

  @Override
  public boolean deleteEvent(String title) {
    Optional<Event> eventOptional = eventRepository.findByTitle(title);
    if (eventOptional.isPresent()) {
      eventRepository.deleteByTitle(title);
      return true;
    }
    return false;
  }
}
