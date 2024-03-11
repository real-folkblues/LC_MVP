package com.example.LC_MVP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LcMvpApplication {

	public static void main ( String[] args ) {
		SpringApplication.run (LcMvpApplication.class, args);
	}

	@Autowired
	private KanjiRepository kanjiRepository;


	public LcMvpApplication ( KanjiRepository kanjiRepository ) {
		this.kanjiRepository = kanjiRepository;
	}

	@Override
	public void run ( String... args ) throws Exception {

	}
}
