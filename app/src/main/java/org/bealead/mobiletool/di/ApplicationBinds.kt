package org.bealead.mobiletool.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import org.bealead.mobiletool.data.pref.PrefDataSource
import org.bealead.mobiletool.data.pref.PrefDataSourceImpl

@Module
@InstallIn(ApplicationComponent::class)
abstract class ApplicationBinds {

    @Binds
    abstract fun bindPrefDataSource(impl: PrefDataSourceImpl): PrefDataSource
}