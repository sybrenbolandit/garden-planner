package nl.sybrenbolandit.gardenplanner.fragment.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository
import java.util.*

class HomeViewModel(application: Application, actionRepository: ActionRepository) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        uiScope.launch {
            actionRepository.refreshActions()
        }
    }

    val actionList: LiveData<List<Action>> = actionRepository.actionList

    private val _navigateToDetails = MutableLiveData<String>()
    val navigateToDetails
        get() = _navigateToDetails

    fun onActionClicked(code: UUID) {
        _navigateToDetails.value = code.toString()
    }

    fun onNavigated() {
        _navigateToDetails.value = null
    }
}
