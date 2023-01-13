package org.bealead.mobiletool.ui.setting

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import kotlinx.coroutines.flow.collectLatest
import org.bealead.mobiletool.domain.GetPageDataUseCase


class SettingViewModel @ViewModelInject constructor(
    private val getPageData: GetPageDataUseCase
) : ViewModel() {

    val urlList = liveData {
        getPageData.getPageData().collectLatest {
            emit(it)
        }
    }

}