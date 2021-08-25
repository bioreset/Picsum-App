package com.dariusz.picsumapp.domain.usecases

import com.dariusz.picsumapp.data.remote.PicsumAppAPIService
import com.dariusz.picsumapp.domain.model.Picture
import javax.inject.Inject

interface ShowListOfImages {

    suspend fun execute(page: Int): List<Picture>
}

class ShowListOfImagesImpl
@Inject constructor(
    private val picsumAppAPIService: PicsumAppAPIService,
) : ShowListOfImages {

    override suspend fun execute(page: Int) = picsumAppAPIService.fetchListOfImages(page)
}
