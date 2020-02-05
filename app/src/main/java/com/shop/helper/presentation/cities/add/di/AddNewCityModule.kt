package com.shop.helper.presentation.cities.add.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.shop.helper.BuildConfig
import com.shop.helper.data.network.places.PlacesRepository
import com.shop.helper.domain.cities.search.SearchCityInteractor
import com.shop.helper.presentation.cities.add.AddNewCityPresenter
import com.shop.helper.utils.DISK_HTTP_CACHE_SIZE
import com.shop.helper.utils.GOOGLE_PLACES_API_KEY
import com.shop.helper.utils.GOOGLE_PLACES_BASE_API_URL
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AddNewCityModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    fun provideOkHttpClient(context: Context): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        if (BuildConfig.DEBUG) {
            logging.level = HttpLoggingInterceptor.Level.BODY
        } else {
            logging.level = HttpLoggingInterceptor.Level.NONE
        }
        val file = File(context.cacheDir, "http")
        val cache = Cache(file, DISK_HTTP_CACHE_SIZE)
        val builder = OkHttpClient.Builder().cache(cache)
        builder.connectTimeout(30, TimeUnit.SECONDS)
        builder.readTimeout(30, TimeUnit.SECONDS)
        builder.writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(logging)

        return builder.build()
    }

    @Provides
    fun provideHttpUrl(): HttpUrl {
        return GOOGLE_PLACES_BASE_API_URL.toHttpUrl()
    }

    @Provides
    fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .client(client)
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    }

    @Provides
    fun providePlacesRepository(retrofit: Retrofit): PlacesRepository {
        return PlacesRepository(retrofit, GOOGLE_PLACES_API_KEY)
    }

    @Provides
    fun provideSearchCityInteractor(repository: PlacesRepository): SearchCityInteractor {
        return SearchCityInteractor(repository)
    }

    @Provides
    fun provideAddNewCityPresenter(interactor: SearchCityInteractor): AddNewCityPresenter {
        return AddNewCityPresenter(interactor)
    }

}