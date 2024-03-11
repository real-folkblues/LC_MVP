package com.example.LC_MVP.controllers;

import com.example.LC_MVP.data.KanjiRepository;
import com.example.LC_MVP.models.Kanji;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin (origins = "http://localhost:3000")
@RestController
public class KanjiController {

	@Autowired
	private KanjiRepository kanjiRepository;

	@PostMapping ("/api/saveKanji")
	public ResponseEntity <Kanji> saveKanji ( @RequestBody Kanji kanjiData ) {
		Kanji savedKanji = kanjiRepository.save (kanjiData);
		return ResponseEntity.ok (savedKanji);
	}


}
