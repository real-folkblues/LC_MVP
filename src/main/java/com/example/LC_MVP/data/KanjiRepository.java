package com.example.LC_MVP.data;


import com.example.LC_MVP.models.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanjiRepository extends JpaRepository <Kanji, Integer> {
}
