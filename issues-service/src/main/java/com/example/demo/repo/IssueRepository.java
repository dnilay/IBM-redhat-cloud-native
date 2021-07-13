package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Issue;
@Repository
public interface IssueRepository extends MongoRepository<Issue, String>{

}
