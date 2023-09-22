package com.arcadefortune.visit_counter.repository;

import com.arcadefortune.visit_counter.model.TotalViews;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TotalViewsRepository extends MongoRepository<TotalViews, String> {

}
