package nl.sybrenbolandit.gardenplanner.fragment.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository

class ActionDetailViewModelFactory(private val actionCode: String) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ActionDetailViewModel::class.java)) {
            return ActionDetailViewModel(actionCode, ActionRepository()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

 