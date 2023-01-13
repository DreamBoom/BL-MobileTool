package org.bealead.mobiletool.data.repo

import org.bealead.mobiletool.data.api.ApiManager
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private val apiManager: ApiManager
) {
}