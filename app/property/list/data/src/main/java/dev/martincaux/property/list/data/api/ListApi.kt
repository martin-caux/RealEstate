package dev.martincaux.property.list.data.api

import dev.martincaux.property.list.data.response.ListResponse
import retrofit2.http.GET

interface ListApi {

    @GET("listings.json")
    suspend fun getListResponse(): ListResponse

}
