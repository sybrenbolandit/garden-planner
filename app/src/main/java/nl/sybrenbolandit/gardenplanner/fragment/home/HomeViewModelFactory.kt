package nl.sybrenbolandit.gardenplanner.fragment.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository

class HomeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(application, ActionRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

