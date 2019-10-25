package nl.sybrenbolandit.gardenplanner.fragment.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository
import nl.sybrenbolandit.gardenplanner.repository.database.GardenPlannerDatabase
import nl.sybrenbolandit.gardenplanner.repository.network.ActionClient

class DetailViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {

            val database = GardenPlannerDatabase.getInstance(application)

            return DetailViewModel(application, ActionRepository(database, ActionClient())) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

