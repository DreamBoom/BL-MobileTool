package org.bealead.mobiletool.data.repo

import org.bealead.mobiletool.data.db.dao.BaseUrlDao
import org.bealead.mobiletool.data.db.model.BaseUrlEntity
import javax.inject.Inject

class BaseUrlRepository @Inject constructor(
    private val baseUrlDao: BaseUrlDao
) {
    suspend fun saveBaseUrl(baseUrl: BaseUrlEntity): Boolean {
        val current = System.currentTimeMillis()
        return if (baseUrl.id > 0) {
            baseUrlDao.update(
                id = baseUrl.id,
                name = baseUrl.name,
                url = baseUrl.url,
                updateTime = current) > 0
        } else {
            baseUrl.updateTime = current
            baseUrl.createTime = current
            baseUrlDao.put(baseUrl) > 0
        }
    }

    suspend fun getBaseUrlList(): List<BaseUrlEntity> {
        return baseUrlDao.all()
    }

    suspend fun hasBaseUrl(url: String): Boolean {
        return baseUrlDao.count(url) > 0
    }

    suspend fun deleteBaseUrl(id: Long): Boolean {
        return baseUrlDao.delete(id) > 0
    }

    suspend fun updateSelectBaseUrl(baseUrl: String): Boolean {
        return baseUrlDao.updateSelect(baseUrl) > 0
    }
}