package com.dicoding.jetpacklivedata

import androidx.lifecycle.LiveData

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class WordRepository(private val wordDao: WordDao){

    // Room execute all queries on a separates thread
    // Observes LiveData will notify the observer when the data has changed
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizeWords()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}