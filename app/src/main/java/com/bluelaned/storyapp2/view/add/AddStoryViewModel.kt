package  com.bluelaned.storyapp2.view.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bluelaned.storyapp2.data.pref.SessionModel
import com.bluelaned.storyapp2.data.repository.StoryRepository
import java.io.File

class AddStoryViewModel(private val repository: StoryRepository) : ViewModel() {

    fun getSession(): LiveData<SessionModel> {
        return repository.getSession()
    }
    fun uploadStories(token: String, file: File, description: String, lat: Double? = null, lon: Double? = null) =
        repository.uploadStories(token, file, description, lat, lon)
}