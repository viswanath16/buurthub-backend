package com.backend.buurthub.mapper;

import com.backend.buurthub.dto.EventDto;
import com.backend.buurthub.entity.Event;

public class EventMapper {

  public static EventDto mapToEventDto(Event event, EventDto eventDto) {
    eventDto.setEventId(event.getEventId());
    eventDto.setTitle(event.getTitle());
    eventDto.setDate(event.getDate());
    eventDto.setAddress(event.getAddress());
    eventDto.setLocationUrl(event.getLocationUrl());
    eventDto.setLocation(mapToLocationDto(event.getLocation(), new EventDto.LocationDto()));
    eventDto.setImage(event.getImage());
    eventDto.setDescription(event.getDescription());
    eventDto.setOrganiser(event.getOrganiser());
    eventDto.setCity(event.getCity());
    eventDto.setTime(event.getTime());
    eventDto.setPrice(event.getPrice() != null ? event.getPrice().name() : null);
    eventDto.setCategory(event.getCategory() != null ? event.getCategory().name() : null);
    eventDto.setParticipants(event.getParticipants());
    return eventDto;
  }

  public static Event mapToEvent(EventDto eventDto, Event event) {
    event.setTitle(eventDto.getTitle());
    event.setDate(eventDto.getDate());
    event.setAddress(eventDto.getAddress());
    event.setLocationUrl(eventDto.getLocationUrl());
    event.setLocation(mapToLocation(eventDto.getLocation(), new Event.Location()));
    event.setImage(eventDto.getImage());
    event.setDescription(eventDto.getDescription());
    event.setOrganiser(eventDto.getOrganiser());
    event.setCity(eventDto.getCity());
    event.setTime(eventDto.getTime());
    event.setPrice(eventDto.getPrice() != null ? Event.Price.valueOf(eventDto.getPrice()) : null);
    event.setCategory(
        eventDto.getCategory() != null ? Event.Category.valueOf(eventDto.getCategory()) : null);
    event.setParticipants(eventDto.getParticipants());
    return event;
  }

  private static EventDto.LocationDto mapToLocationDto(
      Event.Location location, EventDto.LocationDto locationDto) {
    locationDto.setType(location.getType());
    locationDto.setCoordinates(
        mapToCoordinatesDto(location.getCoordinates(), new EventDto.CoordinatesDto()));
    return locationDto;
  }

  private static Event.Location mapToLocation(
      EventDto.LocationDto locationDto, Event.Location location) {
    location.setType(locationDto.getType());
    location.setCoordinates(
        mapToCoordinates(locationDto.getCoordinates(), new Event.Coordinates()));
    return location;
  }

  private static EventDto.CoordinatesDto mapToCoordinatesDto(
      Event.Coordinates coordinates, EventDto.CoordinatesDto coordinatesDto) {
    coordinatesDto.setLatitude(coordinates.getLatitude());
    coordinatesDto.setLongitude(coordinates.getLongitude());
    return coordinatesDto;
  }

  private static Event.Coordinates mapToCoordinates(
      EventDto.CoordinatesDto coordinatesDto, Event.Coordinates coordinates) {
    coordinates.setLatitude(coordinatesDto.getLatitude());
    coordinates.setLongitude(coordinatesDto.getLongitude());
    return coordinates;
  }
}
