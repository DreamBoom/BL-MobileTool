package org.bealead.mobiletool.work

import android.content.Context
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

object WorkHelper {

    /**
     * 检查域名
     * @param context 上下文
     */
    fun checkBaseUrl(context: Context) {
        val workManager = WorkManager.getInstance(context)
        val workRequest = OneTimeWorkRequestBuilder<CheckBaseUrlWork>().build()
        workManager.enqueue(workRequest)
    }
}