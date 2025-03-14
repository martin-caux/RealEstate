package dev.martincaux.core.data.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun provideRetrofit(factory: MoshiConverterFactory): Retrofit {

    return Retrofit.Builder()
        .baseUrl("https://gsl-apps-technical-test.dignp.com/")
        .client(OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }).build())
        .addConverterFactory(factory)
        .build()

}
