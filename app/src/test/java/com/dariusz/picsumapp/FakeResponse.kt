package com.dariusz.picsumapp

import com.dariusz.picsumapp.domain.model.Picture
import com.dariusz.picsumapp.domain.model.PictureDetail
import com.dariusz.picsumapp.domain.model.ResponseState
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import retrofit2.HttpException

object FakeResponse {

    //response from https://picsum.photos/v2/list?page=10&limit=20

    private const val fakeNetworkResponseOne: String = "[{\"id\":\"192\",\"author\":\"Adam Przewoski\",\"width\":2352,\"height\":2352,\"url\":\"https://unsplash.com/photos/umchkHwkdyM\",\"download_url\":\"https://picsum.photos/id/192/2352/2352\"},{\"id\":\"193\",\"author\":\"Vadim Sherbakov\",\"width\":3578,\"height\":2451,\"url\":\"https://unsplash.com/photos/d6ebY-faOO0\",\"download_url\":\"https://picsum.photos/id/193/3578/2451\"},{\"id\":\"194\",\"author\":\"Aleksi Tappura\",\"width\":2000,\"height\":1325,\"url\":\"https://unsplash.com/photos/hVOv8me9ue8\",\"download_url\":\"https://picsum.photos/id/194/2000/1325\"},{\"id\":\"195\",\"author\":\"Matthew Skinner\",\"width\":768,\"height\":1024,\"url\":\"https://unsplash.com/photos/t05kfHeygbE\",\"download_url\":\"https://picsum.photos/id/195/768/1024\"},{\"id\":\"196\",\"author\":\"Dyaa Eldin Moustafa\",\"width\":2048,\"height\":1536,\"url\":\"https://unsplash.com/photos/mR_HR8NZwg8\",\"download_url\":\"https://picsum.photos/id/196/2048/1536\"},{\"id\":\"197\",\"author\":\"Kholodnitskiy Maksim\",\"width\":4272,\"height\":2848,\"url\":\"https://unsplash.com/photos/n6TWNDfyPwk\",\"download_url\":\"https://picsum.photos/id/197/4272/2848\"},{\"id\":\"198\",\"author\":\"Sylwia Bartyzel\",\"width\":3456,\"height\":2304,\"url\":\"https://unsplash.com/photos/FC9mIjVT-Yw\",\"download_url\":\"https://picsum.photos/id/198/3456/2304\"},{\"id\":\"199\",\"author\":\"Beto Galetto\",\"width\":2592,\"height\":1728,\"url\":\"https://unsplash.com/photos/RL0l7Zk5PxU\",\"download_url\":\"https://picsum.photos/id/199/2592/1728\"},{\"id\":\"2\",\"author\":\"Alejandro Escamilla\",\"width\":5616,\"height\":3744,\"url\":\"https://unsplash.com/photos/N7XodRrbzS0\",\"download_url\":\"https://picsum.photos/id/2/5616/3744\"},{\"id\":\"20\",\"author\":\"Aleks Dorohovich\",\"width\":3670,\"height\":2462,\"url\":\"https://unsplash.com/photos/nJdwUHmaY8A\",\"download_url\":\"https://picsum.photos/id/20/3670/2462\"},{\"id\":\"200\",\"author\":\"Elias Carlsson\",\"width\":1920,\"height\":1280,\"url\":\"https://unsplash.com/photos/wSb8d-ke5-4\",\"download_url\":\"https://picsum.photos/id/200/1920/1280\"},{\"id\":\"201\",\"author\":\"Craig Garner\",\"width\":5184,\"height\":3456,\"url\":\"https://unsplash.com/photos/YoadQb46v6k\",\"download_url\":\"https://picsum.photos/id/201/5184/3456\"},{\"id\":\"202\",\"author\":\"Glen Carrie\",\"width\":2392,\"height\":1260,\"url\":\"https://unsplash.com/photos/xlAmGyZE7Zg\",\"download_url\":\"https://picsum.photos/id/202/2392/1260\"},{\"id\":\"203\",\"author\":\"Diogo Tavares\",\"width\":4032,\"height\":3024,\"url\":\"https://unsplash.com/photos/PFZTiiJnjag\",\"download_url\":\"https://picsum.photos/id/203/4032/3024\"},{\"id\":\"204\",\"author\":\"Tiago Gerken\",\"width\":5184,\"height\":3456,\"url\":\"https://unsplash.com/photos/vCqmY3bfqfo\",\"download_url\":\"https://picsum.photos/id/204/5184/3456\"},{\"id\":\"206\",\"author\":\"Philipp Reiner\",\"width\":2880,\"height\":1800,\"url\":\"https://unsplash.com/photos/qPJ6eRAMmCM\",\"download_url\":\"https://picsum.photos/id/206/2880/1800\"},{\"id\":\"208\",\"author\":\"Martin Wessely\",\"width\":2002,\"height\":1280,\"url\":\"https://unsplash.com/photos/NYxxuBSQzp4\",\"download_url\":\"https://picsum.photos/id/208/2002/1280\"},{\"id\":\"209\",\"author\":\"Martin Wessely\",\"width\":1920,\"height\":1280,\"url\":\"https://unsplash.com/photos/-FgZlbzZ0R8\",\"download_url\":\"https://picsum.photos/id/209/1920/1280\"},{\"id\":\"21\",\"author\":\"Alejandro Escamilla\",\"width\":3008,\"height\":2008,\"url\":\"https://unsplash.com/photos/jVb0mSn0LbE\",\"download_url\":\"https://picsum.photos/id/21/3008/2008\"},{\"id\":\"210\",\"author\":\"Martin Wessely\",\"width\":1920,\"height\":1280,\"url\":\"https://unsplash.com/photos/sX4lxBWV0-A\",\"download_url\":\"https://picsum.photos/id/210/1920/1280\"}]"

    //response from https://picsum.photos/id/500/info

    private const val fakeNetworkResponseTwo: String = "{\"id\":\"500\",\"author\":\"Greg Shield\",\"width\":2048,\"height\":1365,\"url\":\"https://unsplash.com/photos/JV4Ic7fSZbw\",\"download_url\":\"https://picsum.photos/id/500/2048/1365\"}"

    private val moshi = Moshi.Builder().build()

    fun getFakeListOfImages(): List<Picture>? {
        val listOfPictures = Types.newParameterizedType(MutableList::class.java, Picture::class.java)
        val jsonAdapter = moshi.adapter<List<Picture>>(listOfPictures)
        return jsonAdapter.fromJson(fakeNetworkResponseOne)
    }

    fun getFakeDetailsOfImage(): PictureDetail? {
        val jsonAdapter = moshi.adapter(PictureDetail::class.java)
        return jsonAdapter.fromJson(fakeNetworkResponseTwo)
    }

    fun generateError(networkType: Boolean? = false) = when (networkType) {
        true -> ResponseState.HttpError(Exception())
        else -> ResponseState.Error(Exception())
    }

}