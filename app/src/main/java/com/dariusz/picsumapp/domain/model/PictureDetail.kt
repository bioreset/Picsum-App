package com.dariusz.picsumapp.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PictureDetail(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "author")
    val author: String,
    @field:Json(name = "width")
    val width: Int,
    @field:Json(name = "height")
    val height: Int,
    @field:Json(name = "url")
    val url: String,
    @field:Json(name = "download_url")
    val downloadUrl: String
)
