package com.dariusz.picsumapp.data.remote

import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail
import com.dariusz.picsumapp.utils.Constants.API_LIST_LIMIT
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PicsumAppAPI {

    @GET("v2/list")
    suspend fun getListOfImages(
        @Query("page") page: Int,
        @Query("limit") limit: Int = API_LIST_LIMIT,
    ): List<Picture>

    @GET("id/{id}/info")
    suspend fun getDataOfImageById(
        @Path("id") id: Int,
    ): PictureDetail
}
