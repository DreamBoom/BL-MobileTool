package org.bealead.mobiletool.utils.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import org.bealead.mobiletool.data.model.BaseUrl

class BaseUrlPagingSource(private val list: List<BaseUrl>): PagingSource<Int, BaseUrl>() {
    override fun getRefreshKey(state: PagingState<Int, BaseUrl>): Int? = null

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, BaseUrl> {
        return try {
            val page = params.key ?: 1
            val prevKey = if (page > 1) page - 1 else null
            val nextKey = if (page < list.size) page + 1 else null
            LoadResult.Page(list, prevKey, nextKey)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}