package dev.martincaux.property.list.domain.di

import dev.martincaux.property.list.domain.usecase.GetListUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val listDomainModule = module {
    factoryOf(::GetListUseCase)
}