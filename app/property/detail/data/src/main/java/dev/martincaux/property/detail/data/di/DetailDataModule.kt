package dev.martincaux.property.detail.data.di

import dev.martincaux.property.detail.data.api.DetailApi
import dev.martincaux.property.detail.data.mapper.DetailMapper
import dev.martincaux.property.detail.data.repository.DetailRepositoryImpl
import dev.martincaux.property.detail.domain.repository.DetailRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val detailDataModule = module {

    single<DetailApi> {
        get<Retrofit>().create(DetailApi::class.java)
    }

    singleOf(::DetailMapper)

    singleOf(::DetailRepositoryImpl) bind DetailRepository::class
}