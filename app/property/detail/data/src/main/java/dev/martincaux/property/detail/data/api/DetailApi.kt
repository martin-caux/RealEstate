package dev.martincaux.property.detail.data.api

import dev.martincaux.property.detail.data.response.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailApi {

    @GET("listings/{itemId}.json")
    suspend fun getDetailResponse(@Path("itemId") itemId: Int): DetailResponse

}
