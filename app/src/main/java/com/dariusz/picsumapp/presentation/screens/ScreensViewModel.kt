package com.dariusz.picsumapp.presentation.screens

import androidx.lifecycle.ViewModel
import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail
import com.dariusz.picsumapp.domain.model.ResponseState
import com.dariusz.picsumapp.domain.usecases.ShowDetailsOfImage
import com.dariusz.picsumapp.domain.usecases.ShowListOfImages
import com.dariusz.picsumapp.utils.ManageFetchedResponse.manageResult
import com.dariusz.picsumapp.utils.ViewModelUtils.launchVMTask
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ScreensViewModel
@Inject constructor(
    private val showListOfImages: ShowListOfImages,
    private val showDetailsOfImage: ShowDetailsOfImage,
) : ViewModel() {

    private val _listOfImages = MutableStateFlow<ResponseState<List<Picture>>>(
        ResponseState.Idle
    )
    val listOfImages = _listOfImages.asStateFlow()

    private val _imageDetails = MutableStateFlow<ResponseState<PictureDetail>>(
        ResponseState.Idle
    )
    val imageDetails = _imageDetails.asStateFlow()

    fun getListOfImages(page: Int) = launchVMTask {
        manageResult(_listOfImages, showListOfImages.execute(page))
    }

    fun getDetailsForImage(imageId: Int) = launchVMTask {
        manageResult(_imageDetails, showDetailsOfImage.execute(imageId))
    }
}
