package dev.martincaux.property.detail.domain.usecase

import co.touchlab.kermit.Logger
import dev.martincaux.property.detail.domain.model.DetailDomain
import dev.martincaux.property.detail.domain.repository.DetailRepository

class GetDetailUseCase(private val repository: DetailRepository, logger: Logger) {

    private val log = logger.withTag("GetDetailUseCase")

    suspend operator fun invoke(itemId: Int): Result<DetailDomain> {
        log.d("GetDetailUseCase.invoke()")
        return repository.getDetail(itemId)
    }
}