package dev.martincaux.property.list.data.di

import dev.martincaux.property.list.data.datasource.ListRemoteDataSource
import dev.martincaux.property.list.data.mapper.ListMapper
import dev.martincaux.property.list.data.repository.ListRepositoryImpl
import dev.martincaux.property.list.domain.repository.ListRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val listDataModule = module {

    single<ListRemoteDataSource> {
        get<Retrofit>().create(ListRemoteDataSource::class.java)
    }

    singleOf(::ListMapper)

    singleOf(::ListRepositoryImpl) bind ListRepository::class
}