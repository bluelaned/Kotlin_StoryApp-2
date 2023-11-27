package com.bluelaned.storyapp2.data.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.bluelaned.storyapp2.data.pref.SessionPreferences
import com.bluelaned.storyapp2.data.repository.StoryRepository
import com.bluelaned.storyapp2.data.retrofit.ApiConfig
import com.bluelaned.storyapp2.database.StoryDatabase
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("token")

object Injection {
    fun provideRepository(context: Context): StoryRepository {
        val dataBase = StoryDatabase.getDatabase(context)
        val pref = SessionPreferences.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return StoryRepository.getInstance(dataBase, pref, apiService)
    }
}