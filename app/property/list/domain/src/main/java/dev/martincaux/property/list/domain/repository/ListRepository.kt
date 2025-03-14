package dev.martincaux.property.list.domain.repository

import dev.martincaux.property.list.domain.model.ListDomain

interface ListRepository {
    suspend fun getList(): Result<ListDomain>
}