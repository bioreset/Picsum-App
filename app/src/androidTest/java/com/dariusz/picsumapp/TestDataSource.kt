package com.dariusz.picsumapp

import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail

object TestDataSource {

    //random data copied from https://picsum.photos/v2/list
    //some details can not match the exact data from response

    val testImagesList = listOf(
        Picture(1, "https://picsum.photos/id/0/5616/3744"),
        Picture(2, "https://picsum.photos/id/10/2500/1667"),
        Picture(3, "https://picsum.photos/id/1022/6000/3376"),
        Picture(4, "https://picsum.photos/id/1016/3844/2563"),
        Picture(5, "https://picsum.photos/id/1020/4288/2848"),
        Picture(6, "https://picsum.photos/id/1003/1181/1772")
    )

    val testImagesWithInfo = listOf(
        PictureDetail(
            1,
            "Alejandro Escamilla",
            2295,
            1474,
            "https://unsplash.com/photos/93Ep1dhTd2s",
            "https://picsum.photos/id/0/5616/3744"
        ),
        PictureDetail(
            2,
            "Danielle MacInnes",
            2738,
            1028,
            "https://unsplash.com/photos/bClr95glx6k",
            "https://picsum.photos/id/10/2500/1667"
        ),
        PictureDetail(
            3,
            "Christopher Campbell",
            2229,
            1990,
            "https://unsplash.com/photos/V6s1cmE39XM",
            "https://picsum.photos/id/1022/6000/3376"
        ),
        PictureDetail(
            4,
            "Roberto Nickson",
            2929,
            1882,
            "https://unsplash.com/photos/_h7aBovKia4",
            "https://picsum.photos/id/1016/3844/2563"
        ),
        PictureDetail(
            5,
            "Cayton Heath",
            2483,
            1779,
            "https://unsplash.com/photos/-oWyJoSqBRM",
            "https://picsum.photos/id/1020/4288/2848"
        ),
        PictureDetail(
            6,
            "Matthew Wiebe",
            1920,
            1080,
            "https://unsplash.com/photos/D8LcRLwZyPs",
            "https://picsum.photos/id/1003/1181/1772"
        ),
    )

    fun List<PictureDetail>.getItemForId(id: Int) = filter {
        it.id == id
    }


}