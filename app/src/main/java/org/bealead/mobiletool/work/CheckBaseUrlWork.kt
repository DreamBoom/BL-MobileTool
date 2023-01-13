package org.bealead.mobiletool.work

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import org.bealead.mobiletool.data.db.model.BaseUrlEntity
import org.bealead.mobiletool.data.pref.PrefDataSource
import org.bealead.mobiletool.data.repo.BaseUrlRepository
import timber.log.Timber

/**
 * 检查当前域名是否包含在域名数据库，没有则添加，并设置isSelect
 */
class CheckBaseUrlWork @WorkerInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val prefs: PrefDataSource,
    private val baseUrlRepo: BaseUrlRepository
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        val currentBaseUrl = prefs.baseUrl
        if (baseUrlRepo.hasBaseUrl(currentBaseUrl)) {
            return Result.success()
        }

        val success = baseUrlRepo.saveBaseUrl(BaseUrlEntity(0, name = "default", url = currentBaseUrl))
                && baseUrlRepo.updateSelectBaseUrl(currentBaseUrl)
        if (success) {
            return Result.success()
        }
        return Result.failure()
    }

}