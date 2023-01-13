package org.bealead.mobiletool.data.model

data class BaseUrl(
    var id: Long = 0,

    var name: String = "",
    var url: String = "",

    var updateTime: Long = 0L,
    var createTime: Long = 0L,

    var isSelect: Boolean = false
)