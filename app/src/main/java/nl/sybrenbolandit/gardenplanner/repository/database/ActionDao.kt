package nl.sybrenbolandit.gardenplanner.repository.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ActionDao {

    @Query("SELECT * FROM actions ORDER BY id DESC")
    fun fetchAllActions(): LiveData<List<DatabaseAction>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(actionList: List<DatabaseAction>)

    @Query("SELECT * FROM actions WHERE code = :code")
    fun findActionByCode(code: String): DatabaseAction

}
