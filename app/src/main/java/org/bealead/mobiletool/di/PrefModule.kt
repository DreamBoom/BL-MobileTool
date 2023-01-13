package org.bealead.mobiletool.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.bealead.common.utils.BasePreferenceDataStore
import org.bealead.common.utils.PreferenceDataStoreUtils
import org.bealead.mobiletool.utils.PREF_NAME
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object PrefModule {

    @Provides
    @Singleton
    fun providePreferenceDataStore(): BasePreferenceDataStore {
        return PreferenceDataStoreUtils.create(PREF_NAME)
    }
}