package dev.martincaux.property.detail.data.datasource

import dev.martincaux.property.detail.data.response.DetailResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface DetailRemoteDataSource {

    @GET("listings/{itemId}.json")
    suspend fun getDetailResponse(@Path("itemId") itemId: Int): Response<DetailResponse>

}
