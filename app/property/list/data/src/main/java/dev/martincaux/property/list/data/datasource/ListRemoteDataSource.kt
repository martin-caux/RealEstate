package dev.martincaux.property.list.data.datasource

import dev.martincaux.property.list.data.response.ListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ListRemoteDataSource {

    @GET("listings.json")
    suspend fun getListResponse(): Response<ListResponse>

}
