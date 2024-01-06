package com.example.core_android.network.api

import com.example.core_android.network.api.constants.Constants
import com.example.core_android.network.api.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

val networkModule = module {
    factory { provideOkHttpClient() }
    factory { providerService(get()) }
    single { provideRetrofit(get()) }
    single { provideToMd5Hash(get()) }
}

fun provideOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

    return OkHttpClient().newBuilder().addInterceptor { chain ->
        val currentTimestamp = System.currentTimeMillis()
        val newUrl = chain.request().url()
            .newBuilder()
            .addQueryParameter(Constants.TS, currentTimestamp.toString())
            .addQueryParameter(Constants.API_KEY, Constants.PUBLIC_KEY)
            .addQueryParameter(
                Constants.HASH,
                provideToMd5Hash(currentTimestamp.toString() + Constants.PRIVATE_KEY + Constants.PUBLIC_KEY)
            ).build()

        val newRequest = chain.request().newBuilder().url(newUrl).build()
        chain.proceed(newRequest)

    }.addInterceptor(httpLoggingInterceptor).build()
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
}

fun provideToMd5Hash(encrypted: String): String {
    var pass = encrypted
    var encryptedString: String? = null
    val md5: MessageDigest
    try {
        md5 = MessageDigest.getInstance("MD5")
        md5.update(pass.toByteArray(), 0, pass.length)
        pass = BigInteger(1, md5.digest()).toString(16)
        while (pass.length < 32) {
            pass = "0$pass"
        }
        encryptedString = pass
    } catch (e1: NoSuchAlgorithmException) {
        e1.printStackTrace()
    }
    Timber.d("hash -> $encryptedString")
    return encryptedString ?: ""
}

fun providerService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)