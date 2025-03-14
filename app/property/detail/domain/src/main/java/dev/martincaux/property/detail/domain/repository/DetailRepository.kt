package dev.martincaux.property.detail.domain.repository

import dev.martincaux.property.detail.domain.model.DetailDomain

interface DetailRepository {
    suspend fun getDetail(itemId: Int): Result<DetailDomain>
}