package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Issue;
import com.example.demo.repo.IssueRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IssueServiceImpl implements IssueService {

	private IssueRepository issueRepository;
	
	@Autowired
	public IssueServiceImpl(IssueRepository issueRepository) {
		this.issueRepository = issueRepository;
	}

	@Override
	public Issue createNewIssue(Issue issue) {
		log.info("within create issue service");
		return issueRepository.insert(issue);
		
	}

	@Override
	public List<Issue> displayAllIssues() {
		log.info("within display issue service");
		return issueRepository.findAll();
	}

	
	
}
