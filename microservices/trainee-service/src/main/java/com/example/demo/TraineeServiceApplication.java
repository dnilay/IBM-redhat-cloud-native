package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.example.demo.dao.TrainerRepository;
import com.example.demo.model.Trainee;

@SpringBootApplication
@EnableEurekaClient
public class TraineeServiceApplication implements CommandLineRunner {
	
	private TrainerRepository trainerRepository;
	

	@Autowired
	public TraineeServiceApplication(TrainerRepository trainerRepository) {
		this.trainerRepository = trainerRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(TraineeServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		trainerRepository.save(new Trainee("John"));
		trainerRepository.save(new Trainee("Mary"));
		trainerRepository.save(new Trainee("Steev"));
		trainerRepository.save(new Trainee("Sachin"));
		
	}

}
