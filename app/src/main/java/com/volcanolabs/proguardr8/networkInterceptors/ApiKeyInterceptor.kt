package com.volcanolabs.proguardr8.networkInterceptors

import com.volcanolabs.proguardr8.Constants.Companion.API_KEY
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("api_key", API_KEY).build()
        val newRequest = request.newBuilder().url(url).build()
        return chain.proceed(newRequest)
    }
}