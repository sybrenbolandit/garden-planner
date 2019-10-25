package nl.sybrenbolandit.gardenplanner.fragment.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository

class HomeViewModel(application: Application, actionRepository: ActionRepository) : AndroidViewModel(application) {

    private val viewModelJob = SupervisorJob()
    private val uiScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        uiScope.launch {
            actionRepository.refreshActions()
        }
    }

    val actionList: LiveData<List<Action>> = actionRepository.actionList
}
