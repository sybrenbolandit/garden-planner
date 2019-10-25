package nl.sybrenbolandit.gardenplanner.fragment.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository
import nl.sybrenbolandit.gardenplanner.repository.database.GardenPlannerDatabase
import nl.sybrenbolandit.gardenplanner.repository.network.ActionClient

class HomeViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {

            val database = GardenPlannerDatabase.getInstance(application)

            return HomeViewModel(application, ActionRepository(database, ActionClient())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

