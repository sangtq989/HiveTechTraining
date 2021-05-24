package com.sang.cascade.repo;

import com.sang.cascade.entity.presist.Story;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

public interface StoryRepository  extends CrudRepository<Story, Serializable> {
}
