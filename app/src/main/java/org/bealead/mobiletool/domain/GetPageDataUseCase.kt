package org.bealead.mobiletool.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import org.bealead.mobiletool.data.model.BaseUrl
import org.bealead.mobiletool.data.repo.BaseUrlRepository
import org.bealead.mobiletool.utils.paging.BaseUrlPagingSource
import javax.inject.Inject

class GetPageDataUseCase @Inject constructor(
    private val baseUrlRepo: BaseUrlRepository
) {
    suspend fun getPageData(): Flow<PagingData<BaseUrl>> {
        val urlList = baseUrlRepo.getBaseUrlList().map {
            BaseUrl(
                it.id,
                it.name,
                it.url,
                it.updateTime,
                it.createTime,
                it.isSelect
            )
        }
        return Pager(
            config = PagingConfig(10),
            pagingSourceFactory = { BaseUrlPagingSource(urlList)}
        ).flow
    }
}