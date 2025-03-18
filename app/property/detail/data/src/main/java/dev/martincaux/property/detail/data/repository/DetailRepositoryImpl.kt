package dev.martincaux.property.detail.data.repository

import co.touchlab.kermit.Logger
import dev.martincaux.property.detail.data.datasource.DetailRemoteDataSource
import dev.martincaux.property.detail.data.mapper.DetailMapper
import dev.martincaux.property.detail.domain.model.DetailDomain
import dev.martincaux.property.detail.domain.repository.DetailRepository
import java.lang.Exception

class DetailRepositoryImpl(
    private val detailRemoteDataSource: DetailRemoteDataSource, private val mapper: DetailMapper, logger: Logger
) : DetailRepository {

    private val log = logger.withTag("DetailRepositoryImpl")

    override suspend fun getDetail(itemId: Int): Result<DetailDomain> {
        log.d { "Fetching detail" }
        return kotlin.runCatching {
            detailRemoteDataSource.getDetailResponse(itemId).let { response ->
                if (response.isSuccessful) {
                    response.body()?.let(mapper::map)
                } else {
                    throw Exception("Network Error")
                }
            } ?: throw Exception("Detail missing mandatory fields")
        }
    }
}