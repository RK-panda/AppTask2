package com.example.apptask2.models

data class ReturnedResults<T>(

    val status:Boolean,
    val message:String,
    val data:T,
    val count: Int

    )
