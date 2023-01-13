package org.bealead.mobiletool.data.pref

import org.bealead.common.utils.BasePreferenceDataStore
import org.bealead.common.utils.string
import org.bealead.mobiletool.utils.APP_DEFAULT_BASE_URL
import javax.inject.Inject

class PrefDataSourceImpl @Inject constructor(
    prefs: BasePreferenceDataStore
): PrefDataSource {
    override var baseUrl by prefs.string("Prefs_base_url", APP_DEFAULT_BASE_URL)
}