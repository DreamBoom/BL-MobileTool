package org.bealead.mobiletool.data.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.bealead.mobiletool.data.db.model.BaseUrlEntity

@Dao
interface BaseUrlDao {
    @Query("SELECT * FROM BaseUrl_Table")
    suspend fun all(): List<BaseUrlEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun put(baseUrl: BaseUrlEntity): Long

    @Query("DELETE FROM BaseUrl_Table")
    suspend fun clear()

    @Query("UPDATE BaseUrl_Table SET name=:name, url=:url, updateTime=:updateTime AND name=:name WHERE _id=:id")
    suspend fun update(id: Long, name: String, url: String, updateTime: Long): Int

    @Query("SELECT COUNT(_id) FROM BaseUrl_Table")
    suspend fun count(): Int

    @Query("SELECT COUNT(_id) FROM BaseUrl_Table WHERE url=:url")
    suspend fun count(url: String): Int

    @Query("DELETE FROM BaseUrl_Table WHERE _id=:id")
    suspend fun delete(id: Long): Int

    /**
     * 更新目标域名与选中域名
     * 目标域名isSelect=true，其他选中域名(一般为一条)isSelect=false
     */
    @Query("""
        UPDATE BaseUrl_table 
        SET isSelect = CASE url WHEN :baseUrl THEN 1 ELSE 0 END
        WHERE url=:baseUrl OR isSelect=1
    """)
    suspend fun updateSelect(baseUrl: String): Int
}