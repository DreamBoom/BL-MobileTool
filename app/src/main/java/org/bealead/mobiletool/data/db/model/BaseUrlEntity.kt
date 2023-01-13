package org.bealead.mobiletool.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BaseUrl_Table")
data class BaseUrlEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id")
    var id: Long = 0, // 自增Id

    var name: String = "",
    var url: String = "",

    var updateTime: Long = 0L,
    var createTime: Long = 0L,

    var isSelect: Boolean = false
)