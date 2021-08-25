package com.dariusz.picsumapp.domain.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Picture(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "download_url")
    val downloadUrl: String
)
