package dev.martincaux.property.list.data.repository

import co.touchlab.kermit.Logger
import dev.martincaux.property.list.data.datasource.ListRemoteDataSource
import dev.martincaux.property.list.data.mapper.ListMapper
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.repository.ListRepository

class ListRepositoryImpl(
    private val listRemoteDataSource: ListRemoteDataSource, private val mapper: ListMapper, logger: Logger
) : ListRepository {

    private val log = logger.withTag("ListRepositoryImpl")

    override suspend fun getList(): Result<ListDomain> {
        log.d { "Fetching list" }
        return kotlin.runCatching {
            listRemoteDataSource.getListResponse().let { response ->
                if (response.isSuccessful) {
                    response.body()?.let(mapper::map) ?: throw Exception("Network Error")
                } else {
                    throw Exception("Network Error")
                }
            }
        }
    }
}