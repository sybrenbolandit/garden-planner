package nl.sybrenbolandit.gardenplanner.repository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DatabaseAction::class], version = 1, exportSchema = false)
abstract class GardenPlannerDatabase: RoomDatabase() {

    abstract val actionDao: ActionDao

    companion object {
        @Volatile
        private var INSTANCE: GardenPlannerDatabase? = null

        fun getInstance(context: Context): GardenPlannerDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            GardenPlannerDatabase::class.java,
                            "gardenplanner_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                }

                return instance
            }
        }
    }
}
