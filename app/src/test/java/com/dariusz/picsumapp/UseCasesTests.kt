package com.dariusz.picsumapp

import com.dariusz.picsumapp.FakeResponse.getFakeDetailsOfImage
import com.dariusz.picsumapp.FakeResponse.getFakeListOfImages
import com.dariusz.picsumapp.data.remote.PicsumAppAPIServiceImpl
import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail
import com.dariusz.picsumapp.domain.usecases.ShowDetailsOfImage
import com.dariusz.picsumapp.domain.usecases.ShowDetailsOfImageImpl
import com.dariusz.picsumapp.domain.usecases.ShowListOfImages
import com.dariusz.picsumapp.domain.usecases.ShowListOfImagesImpl
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class UseCasesTests {

    private lateinit var showListOfImages: ShowListOfImages

    private lateinit var showDetailsOfImage: ShowDetailsOfImage

    private lateinit var fakeResponseOne: List<Picture>

    private lateinit var fakeResponseTwo: PictureDetail

    @Before
    fun setUp(){
        showListOfImages = ShowListOfImagesImpl(PicsumAppAPIServiceImpl())
        showDetailsOfImage = ShowDetailsOfImageImpl(PicsumAppAPIServiceImpl())
        fakeResponseOne = getFakeListOfImages()!!
        fakeResponseTwo = getFakeDetailsOfImage()!!
    }

    @Test
    fun checkListOfImages() = runBlocking {
        assert(fakeResponseOne == showListOfImages.execute(10))
    }

    @Test
    fun checkDetail() = runBlocking {
        assert(fakeResponseTwo == showDetailsOfImage.execute(500))
    }

}