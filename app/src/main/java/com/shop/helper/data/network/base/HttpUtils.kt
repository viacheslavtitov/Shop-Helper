package com.shop.helper.data.network.base

import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shop.helper.BuildConfig
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

fun provideOkHttpClient(
    app: Application,
    diskCache: Long
): OkHttpClient {
    val logging = HttpLoggingInterceptor()
    if (BuildConfig.DEBUG) {
        logging.level = HttpLoggingInterceptor.Level.BODY
    } else {
        logging.level = HttpLoggingInterceptor.Level.NONE
    }
    return createOkHttpClient(app, diskCache)
        .addInterceptor(logging)
        .build()
}

fun createOkHttpClient(app: Application, diskCache: Long): OkHttpClient.Builder {
    val cacheDir = File(app.cacheDir, "http")
    val cache = Cache(cacheDir, diskCache)

    val builder = OkHttpClient.Builder().cache(cache)
    builder.connectTimeout(30, TimeUnit.SECONDS)
    builder.readTimeout(30, TimeUnit.SECONDS)
    builder.writeTimeout(30, TimeUnit.SECONDS)

    return builder
}

fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build();
}

fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(client)
        .baseUrl(baseUrl)
        .build();
}

fun provideGson(): Gson {
    return GsonBuilder().create()
}

fun provideHttpUrl(url: String): HttpUrl {
    return url.toHttpUrl()
}