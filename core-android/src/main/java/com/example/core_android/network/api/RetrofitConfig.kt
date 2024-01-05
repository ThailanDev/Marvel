package com.example.core_android.network.api

import com.example.core_android.network.api.constants.Constants
import com.example.core_android.network.api.service.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { providerService(get()) }
    single { provideRetrofit(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient()
}
fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()
}

fun providerService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)