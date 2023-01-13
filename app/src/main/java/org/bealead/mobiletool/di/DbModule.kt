package org.bealead.mobiletool.di

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.bealead.mobiletool.data.db.AppDataBase
import org.bealead.mobiletool.data.db.dao.BaseUrlDao
import org.bealead.mobiletool.utils.APP_DB_NAME
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DbModule {

    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): AppDataBase {
        return AppDataBase.create(application, APP_DB_NAME)
    }

    @Provides
    @Singleton
    fun provideBaseUrlDao(appDataBase: AppDataBase): BaseUrlDao {
        return appDataBase.baseUrlDao()
    }
}