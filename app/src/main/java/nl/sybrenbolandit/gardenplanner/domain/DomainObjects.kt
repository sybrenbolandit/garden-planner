package nl.sybrenbolandit.gardenplanner.domain

import java.util.UUID

data class Action(val title: String, val code: UUID, val description: String, val type: ActionType)

enum class ActionType {
    ADDITION,
    MAINTENANCE,
    ALERT
}