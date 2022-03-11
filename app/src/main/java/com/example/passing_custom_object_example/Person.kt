package com.example.passing_custom_object_example

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    var firstName: String,
    var surname: String,
    var address: Address
) : Parcelable
