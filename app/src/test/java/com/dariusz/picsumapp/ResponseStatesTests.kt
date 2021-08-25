package com.dariusz.picsumapp

import com.dariusz.picsumapp.FakeResponse.generateError
import com.dariusz.picsumapp.FakeResponse.getFakeDetailsOfImage
import com.dariusz.picsumapp.FakeResponse.getFakeListOfImages
import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail
import com.dariusz.picsumapp.domain.model.ResponseState
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ResponseStatesTests {

    private lateinit var responseStateOne: ResponseState<List<Picture>>

    private lateinit var responseStateTwo: ResponseState<PictureDetail>

    @Before
    fun setUp(){
        responseStateOne = ResponseState.Idle
        responseStateTwo = ResponseState.Idle
    }

    @Test
    fun checkResponseStateIfIdle() = runBlocking {
        assert(responseStateOne == ResponseState.Idle)
        assert(responseStateTwo == ResponseState.Idle)
    }

    @Test
    fun checkResponseStateIfLoading() = runBlocking {
        responseStateOne = ResponseState.Loading
        responseStateTwo = ResponseState.Idle
        assert(responseStateOne == ResponseState.Loading)
        assert(responseStateTwo != ResponseState.Loading)
    }

    @Test
    fun checkResponseIfSuccessful() = runBlocking {
        responseStateOne = ResponseState.Success(getFakeListOfImages()!!)
        responseStateTwo = ResponseState.Success(getFakeDetailsOfImage()!!)
        assert(responseStateOne is ResponseState.Success<List<Picture>>)
        assert(responseStateTwo is ResponseState.Success<PictureDetail>)
    }

    @Test
    fun checkResponseIfAnyError() = runBlocking {
        responseStateOne = generateError()
        responseStateTwo = generateError(true)
        assert(responseStateOne is ResponseState.Error)
        assert(responseStateTwo is ResponseState.HttpError)
    }


}