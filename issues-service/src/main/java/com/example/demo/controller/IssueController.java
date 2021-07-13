package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Issue;
import com.example.demo.service.IssueService;

@RestController
public class IssueController {

	private IssueService issueService;
	private Environment environment;
	@Autowired
	public IssueController(IssueService issueService, Environment environment) {
		this.issueService = issueService;
		this.environment = environment;
	}
	@GetMapping
	public ResponseEntity<String> getStatus()
	{
		return new ResponseEntity<String>("issue service is up and running on port: "+environment.getProperty("local.server.port"),HttpStatus.OK);
	}
	
	@PostMapping("/issues")
	public ResponseEntity<Issue> createIssue(@RequestBody Issue issue)
	{
		return new ResponseEntity<Issue>(issueService.createNewIssue(issue),HttpStatus.CREATED);
	}
	
	@GetMapping("/issues")
	public ResponseEntity<List<Issue>> displayIssues()
	{
		return new ResponseEntity<List<Issue>>(issueService.displayAllIssues(),HttpStatus.OK);
	}
	
}
