package dev.martincaux.property.list.domain.usecase

import co.touchlab.kermit.Logger
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.repository.ListRepository

class GetListUseCase(private val repository: ListRepository, logger: Logger) {

    private val log = logger.withTag("GetListUseCase")

    suspend operator fun invoke(): Result<ListDomain> {
        log.d("GetListUseCase.invoke()")
        return repository.getList()
    }
}