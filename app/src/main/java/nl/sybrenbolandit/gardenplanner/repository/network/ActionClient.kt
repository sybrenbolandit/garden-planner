package nl.sybrenbolandit.gardenplanner.repository.network

import android.os.SystemClock
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import nl.sybrenbolandit.gardenplanner.domain.Action
import nl.sybrenbolandit.gardenplanner.domain.ActionType
import nl.sybrenbolandit.gardenplanner.repository.database.GardenPlannerDatabase
import java.util.*

class ActionClient {

    fun fetchActions(): Deferred<List<Action>> {

        SystemClock.sleep(5000)

        val data = listOf(
                Action("Plant flower bulbs for the spring", UUID.fromString("325af792-4768-410d-a058-f446488f3a54"), "This is the ideal time to start planting flower bulbs so you have a floral greeting in the spring.", ActionType.ADDITION),
                Action("Attend your trees", UUID.fromString("5fbf6305-6e47-48f0-8e1c-727cdb6df023"), "Before it will freeze in the night time you can cut the branches of your trees.", ActionType.MAINTENANCE),
                Action("Your garden need water! ", UUID.fromString("2ed85fb7-5557-4163-b751-5175f587fe1d"), "It hasn't rained in quite some time now. Without watering your garden some plants might not survive.", ActionType.ALERT),
                Action("Plant paprika", UUID.fromString("edb121d4-f91e-4769-9ef4-ab0aba6ba62e"), "Take the seeds of a paprika and put them in wet earth in front of your window.", ActionType.ADDITION),
                Action("Create your own greenhouse", UUID.fromString("61027ffa-0cc9-48e4-b15f-e033a3e98fed"), "DIY green house for tropical plants and vegetables! With everyday materials you can build one.", ActionType.ADDITION),
                Action("Get some food", UUID.fromString("dc5da6d6-caf4-45f2-a8d4-8b87fcfbf0ff"), "Plants need food too. Buy some plant food and feed them.", ActionType.MAINTENANCE),
                Action("Clean up", UUID.fromString("aa2b3377-2363-4156-995d-327fa9813a38"), "Some little plant you don't like. Make sure your own plant can grow the most.", ActionType.MAINTENANCE)
        )

        return GlobalScope.async { data }
    }

}

