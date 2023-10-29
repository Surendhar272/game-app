package com.tekion.cricketgame.repository;

import com.tekion.cricketgame.entity.ResultSummaryEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ResultSummaryRepository extends MongoRepository<ResultSummaryEntity, String> {
//    Collection<ResultSummaryEntity> findByMatch(Integer match);
}