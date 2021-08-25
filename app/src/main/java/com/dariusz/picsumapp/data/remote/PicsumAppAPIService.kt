package com.dariusz.picsumapp.data.remote

import com.dariusz.picsumapp.di.NetworkModule.provideRetrofit
import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail
import javax.inject.Inject

interface PicsumAppAPIService {

    suspend fun fetchListOfImages(page: Int): List<Picture>

    suspend fun fetchInfoAboutImage(imageId: Int): PictureDetail
}

class PicsumAppAPIServiceImpl
@Inject constructor() :
    PicsumAppAPIService {

    private val retrofit = provideRetrofit()

    override suspend fun fetchListOfImages(page: Int) = retrofit.getListOfImages(page)

    override suspend fun fetchInfoAboutImage(imageId: Int) = retrofit.getDataOfImageById(imageId)
}
