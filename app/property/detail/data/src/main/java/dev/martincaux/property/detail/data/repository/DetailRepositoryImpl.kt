package dev.martincaux.property.detail.data.repository

import co.touchlab.kermit.Logger
import dev.martincaux.property.detail.data.api.DetailApi
import dev.martincaux.property.detail.data.mapper.DetailMapper
import dev.martincaux.property.detail.domain.model.DetailDomain
import dev.martincaux.property.detail.domain.repository.DetailRepository

class DetailRepositoryImpl(
    private val detailApi: DetailApi, private val mapper: DetailMapper, logger: Logger
) : DetailRepository {

    private val log = logger.withTag("DetailRepositoryImpl")

    override suspend fun getDetail(itemId: Int): Result<DetailDomain> {
        log.d { "Fetching detail" }
        return kotlin.runCatching {
//            detailApi.getDetailResponse(itemId).let(mapper::map)
//                ?: throw Exception("Error fetching detail")
            throw Exception("Error fetching detail")
        }
    }
}