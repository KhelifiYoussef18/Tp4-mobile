package com.example.enetcom.roomwordsample.data.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.enetcom.roomwordsample.model.Word;

import java.util.List;

public interface WordDao {
    LiveData<List<Word>> getAlphabetizedWords();

    Object insert(Word word);

    void deleteAll();

    @Dao
    public interface wordDao {

        // Permettre l'insertion du même mot plusieurs fois en passant
        // une stratégie de résolution de conflits.
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        void insert(Word word);

        @Query("DELETE FROM word_table")
        void deleteAll();

        @Query("SELECT * FROM word_table ORDER BY word ASC")
        LiveData<List<Word>> getAlphabetizedWords(); // enveloppe
    }
}
