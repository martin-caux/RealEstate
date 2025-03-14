package dev.martincaux.property.list.data.repository

import co.touchlab.kermit.Logger
import dev.martincaux.property.list.data.api.ListApi
import dev.martincaux.property.list.data.mapper.ListMapper
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.repository.ListRepository

class ListRepositoryImpl(
    private val listApi: ListApi,
    private val mapper: ListMapper,
    logger: Logger
) : ListRepository {

    private val log = logger.withTag("ListRepositoryImpl")

    override suspend fun getList(): Result<ListDomain> {
        log.d { "Fetching list" }
        return kotlin.runCatching {
            listApi.getListResponse().let(mapper::map) ?: throw Exception("Error fetching list")
        }
    }
}