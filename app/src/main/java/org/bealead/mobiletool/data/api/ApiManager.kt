package org.bealead.mobiletool.data.api

import org.bealead.mobiletool.data.pref.PrefDataSource
import javax.inject.Inject

class ApiManager @Inject constructor(
    private val prefs: PrefDataSource,
    private val apiGenerator: ApiServiceGenerator
) {
    private var currentBaseUrl = ""
    private lateinit var currentApiService: ApiService

    fun getApiService(): ApiService {
        val baseUrl = prefs.baseUrl
        if (baseUrl != currentBaseUrl) {
            currentBaseUrl = prefs.baseUrl
            currentApiService = apiGenerator.create(currentBaseUrl)
        }
        return currentApiService
    }
}