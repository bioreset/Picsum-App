package com.dariusz.picsumapp.di

import com.dariusz.picsumapp.data.remote.PicsumAppAPIServiceImpl
import com.dariusz.picsumapp.domain.usecases.ShowDetailsOfImage
import com.dariusz.picsumapp.domain.usecases.ShowDetailsOfImageImpl
import com.dariusz.picsumapp.domain.usecases.ShowListOfImages
import com.dariusz.picsumapp.domain.usecases.ShowListOfImagesImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Provides
    fun provideShowListOfImagesAction(): ShowListOfImages = ShowListOfImagesImpl(
        PicsumAppAPIServiceImpl()
    )

    @Provides
    fun provideShowDetailsOfImageAction(): ShowDetailsOfImage = ShowDetailsOfImageImpl(
        PicsumAppAPIServiceImpl()
    )
}
