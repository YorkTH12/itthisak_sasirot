package com.itthisak.newton.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.itthisak.newton.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

}