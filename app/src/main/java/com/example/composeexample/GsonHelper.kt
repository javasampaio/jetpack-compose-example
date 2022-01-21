@file:JvmName("GsonHelper")
package com.example.composeexample

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

inline fun <reified T> T.stringify(): String {
    return Gson().toJson(this)
}

inline fun <reified T> String.toObject(): T? {
    return Gson().fromJson(this, object : TypeToken<T>() {}.type)
}