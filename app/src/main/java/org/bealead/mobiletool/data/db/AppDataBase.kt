package org.bealead.mobiletool.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.bealead.mobiletool.data.db.dao.BaseUrlDao
import org.bealead.mobiletool.data.db.model.BaseUrlEntity

@Database(entities = [BaseUrlEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {
    companion object {
        fun create(context: Context, dbName: String): AppDataBase {
            return Room.databaseBuilder(context, AppDataBase::class.java, dbName)
                .build()
        }
    }

    abstract fun baseUrlDao(): BaseUrlDao
}