package com.example.LC_MVP.data;

import com.example.LC_MVP.models.Kanji;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepository extends org.springframework.data.jpa.repository.JpaRepository <Kanji, Integer> {

	Kanji findByKanji ( String kanji );

}