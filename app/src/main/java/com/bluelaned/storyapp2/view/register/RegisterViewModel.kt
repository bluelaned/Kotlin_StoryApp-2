package com.bluelaned.storyapp2.view.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bluelaned.storyapp2.data.repository.StoryRepository
import com.bluelaned.storyapp2.Response.RegisterResponse
import com.bluelaned.storyapp2.data.di.Event
import kotlinx.coroutines.launch

class RegisterViewModel (private val repository: StoryRepository) : ViewModel() {
    val isLoading: LiveData<Boolean> = repository.isLoading
    val registerResponse: LiveData<RegisterResponse> = repository.registerResponse
    val toastText: LiveData<Event<String>> = repository.toastText

    fun postRegister(name: String, email: String, password: String) {
        viewModelScope.launch {
            repository.postRegister(name, email, password)
        }
    }
}