package com.example.rako.di

import android.content.Context
import com.example.rako.data.remote.RakoApi
import com.example.rako.util.CachePreferencesHelper
import com.example.rako.util.CoroutineContextProvider
import com.example.rako.util.CoroutineContextProviderImp
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


val moshi: Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRakoApi(): RakoApi {
        return Retrofit.Builder()
            .baseUrl("BASE_URL")
            .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
            .client(createOkHttpClient(createLoggingInterceptor()))
            .build()
            .create(RakoApi::class.java)
    }

    private fun createOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val OK_HTTP_TIMEOUT = 60L
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .connectTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(OK_HTTP_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private fun createLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (true) {
                HttpLoggingInterceptor.Level.BASIC
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Provides
    @Singleton
    fun provideCoroutineContextProvider(contextProvider: CoroutineContextProviderImp): CoroutineContextProvider =
        contextProvider
}

@Provides
@Singleton
fun providePreferenceHelper(@ApplicationContext context: Context): CachePreferencesHelper {
    return CachePreferencesHelper(context)
}

