package com.arcadefortune.visit_counter.repository;

import com.arcadefortune.visit_counter.model.Viewer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ViewerRepository extends MongoRepository<Viewer, String> {
    @Query("{ip: ?0 }")
    List<Viewer> findViewerByIp(String ip);
}