package nl.sybrenbolandit.gardenplanner.fragment.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository
import java.util.*

class DetailViewModel(application: Application, private val actionRepository: ActionRepository) : AndroidViewModel(application) {

    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _action = MutableLiveData<Action>()
    val action: LiveData<Action>
        get() = _action

    fun fetchAction(code: UUID) {
        uiScope.launch {
            _action.value = actionRepository.findAction(code).await()
        }
    }
}
