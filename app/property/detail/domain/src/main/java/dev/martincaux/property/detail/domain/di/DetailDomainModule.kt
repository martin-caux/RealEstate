package dev.martincaux.property.detail.domain.di

import dev.martincaux.property.detail.domain.GetDetailUseCase
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val detailDomainModule = module {
    factoryOf(::GetDetailUseCase)
}