package nl.sybrenbolandit.gardenplanner.fragment.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.repository.ActionRepository


class HomeViewModel(application: Application, actionRepository: ActionRepository) : AndroidViewModel(application) {

    val actionList: LiveData<List<Action>> = actionRepository.actionList
}
