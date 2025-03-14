package dev.martincaux.core.data.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dev.martincaux.core.data.network.provideRetrofit
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val coreDataModule = module {

    single<Moshi> {
        Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    single<MoshiConverterFactory> {
        MoshiConverterFactory.create(get())
    }

    single<Retrofit> {
        provideRetrofit(get())
    }

}