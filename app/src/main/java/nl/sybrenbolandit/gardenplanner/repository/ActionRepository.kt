package nl.sybrenbolandit.gardenplanner.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.repository.database.GardenPlannerDatabase
import nl.sybrenbolandit.gardenplanner.repository.database.asDatabaseEntities
import nl.sybrenbolandit.gardenplanner.repository.database.asDomainModel
import nl.sybrenbolandit.gardenplanner.repository.network.ActionClient
import java.util.*

class ActionRepository(private val database: GardenPlannerDatabase, private val actionClient: ActionClient) {

    val actionList: LiveData<List<Action>> = Transformations.map(database.actionDao.fetchAllActions()) {
        it.asDomainModel()
    }

    suspend fun refreshActions() {
        withContext(Dispatchers.IO) {
            val actionList = actionClient.fetchActions().await()
            database.actionDao.insertAll(actionList.asDatabaseEntities())
        }
    }

    suspend fun findAction(code: UUID): Deferred<Action> {
        return withContext(Dispatchers.IO) {
            async {
                database.actionDao.findActionByCode(code.toString()).asDomainModel()
            }
        }
    }
}

