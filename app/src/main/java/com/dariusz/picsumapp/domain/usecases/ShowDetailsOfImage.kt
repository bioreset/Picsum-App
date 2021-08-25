package com.dariusz.picsumapp.domain.usecases

import com.dariusz.picsumapp.data.remote.PicsumAppAPIService
import com.dariusz.picsumapp.domain.model.PictureDetail
import javax.inject.Inject

interface ShowDetailsOfImage {

    suspend fun execute(imageId: Int): PictureDetail
}

class ShowDetailsOfImageImpl
@Inject constructor(
    private val picsumAppAPIService: PicsumAppAPIService,
) : ShowDetailsOfImage {

    override suspend fun execute(imageId: Int) = picsumAppAPIService.fetchInfoAboutImage(imageId)
}
