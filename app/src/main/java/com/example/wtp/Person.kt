package com.example.wtp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Person(val name:String, val image : Int, val money: String) : Parcelable