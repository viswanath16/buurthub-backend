package com.backend.buurthub.service;

import com.backend.buurthub.dto.EventDto;

public interface IEventService {
  void createEvent(EventDto eventDto);

  EventDto fetchEvent(String title);

  boolean updateEvent(EventDto eventDto);

  boolean deleteEvent(String title);
}
