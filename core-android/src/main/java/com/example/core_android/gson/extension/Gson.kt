package com.example.core_android.gson.extension

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Response

inline fun <reified T> resolveApi(response: Response<Any>): T {
    return Gson().fromJson<T>(response)
}
inline fun <reified T> Gson.fromJson(response: Response<Any>): T {
    val json = Gson().toJson(response.body())
    return fromJson(json, object : TypeToken<T>() {}.type)
}