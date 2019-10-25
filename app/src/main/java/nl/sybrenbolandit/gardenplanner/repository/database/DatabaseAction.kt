package nl.sybrenbolandit.gardenplanner.repository.database

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.domain.ActionType
import java.util.*

@Entity(tableName = "actions",
        indices = [Index(value = ["code"], unique = true)])
data class DatabaseAction(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0L,

        var title: String,

        var code: String,

        var description: String,

        var type: String
)

fun List<DatabaseAction>.asDomainModel(): List<Action> {
    return map { it.asDomainModel() }
}

fun DatabaseAction.asDomainModel(): Action {
    return Action(
            title = title,
            code = UUID.fromString(code),
            description = description,
            type = ActionType.valueOf(type)
    )
}

fun List<Action>.asDatabaseEntities(): List<DatabaseAction> {
    return map {
        DatabaseAction(
                title = it.title,
                code = it.code.toString(),
                description = it.description,
                type = it.type.toString()
        )
    }
}
