package com.bluelaned.storyapp2.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bluelaned.storyapp2.data.pref.SessionModel
import com.bluelaned.storyapp2.data.repository.StoryRepository
import com.bluelaned.storyapp2.Response.ListStoryItem
import com.bluelaned.storyapp2.Response.StoryResponse
import com.bluelaned.storyapp2.data.di.Event
import kotlinx.coroutines.launch

class MainViewModel(private val repository: StoryRepository) : ViewModel() {
    val list: LiveData<StoryResponse> = repository.list
    val isLoading: LiveData<Boolean> = repository.isLoading
    val toastText: LiveData<Event<String>> = repository.toastText
    val getListStories: LiveData<PagingData<ListStoryItem>> =
        repository.getStories().cachedIn(viewModelScope)

    fun getSession(): LiveData<SessionModel> {
        return repository.getSession()
    }

    fun logout() {
        viewModelScope.launch {
            repository.logout()
        }
    }

    fun getListStoriesWithLocation(token: String) {
        viewModelScope.launch {
            repository.getListStoriesWithLocation(token)
        }
    }

    val story: LiveData<PagingData<ListStoryItem>> = repository.getStories().cachedIn(viewModelScope)
}