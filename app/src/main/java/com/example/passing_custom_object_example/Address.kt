package com.example.passing_custom_object_example

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Address(
    var houseNameNumber: String,
    var street: String,
    var town : String,
    var postcode: String
) : Parcelable
