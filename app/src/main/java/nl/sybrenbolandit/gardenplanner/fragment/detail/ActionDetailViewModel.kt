package nl.sybrenbolandit.gardenplanner.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Job
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository
import java.util.*


class ActionDetailViewModel(actionCode: String, actionRepository: ActionRepository) : ViewModel() {

    private val viewModelJob = Job()

    private val action = MediatorLiveData<Action>()

    fun getAction() = action

    init {
        action.addSource(actionRepository.getAction(UUID.fromString(actionCode)), action::setValue)
    }


    private val _navigateHome = MutableLiveData<Boolean?>()
    val navigateHome: LiveData<Boolean?>
        get() = _navigateHome


    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    fun doneNavigating() {
        _navigateHome.value = null
    }
}

 