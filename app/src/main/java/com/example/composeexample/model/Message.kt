package com.example.composeexample.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Message(
    val author: String,
    val message: String
) : Parcelable