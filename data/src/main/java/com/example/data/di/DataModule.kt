package com.example.data.di

import com.example.data.repository.SportEventsRepositoryImpl
import com.example.data.repository.remote.SportEventsService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object DataModule {

    private const val BASE_URL = "https://618d3aa7fe09aa001744060a.mockapi.io/api/"
    private const val TIME_OUT = 30L

    fun loadModules() {
        loadKoinModules(
    remoteModule +
            repositoryModule
        )
    }

    private val remoteModule = module {
        single { buildApiService(get()) }

        single { buildRetrofit(get(), BASE_URL) }

        single { buildLoggingInterceptor() }

        single { buildHttpClient(get()) }
    }

    private val repositoryModule = module {
        single { buildRepository(
            service = get()
        ) }
    }

    private fun buildRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
        val moshi by lazy {
            val moshiBuilder = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
            moshiBuilder.build()
        }

        return Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
//            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    private fun buildHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    private fun buildApiService(retrofit: Retrofit): SportEventsService {
        return retrofit.create(SportEventsService::class.java)
    }

    private fun buildRepository(
        service: SportEventsService
    ) = SportEventsRepositoryImpl(
        service = service
    )

    private fun buildLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }
}