package com.example.androiddevchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyCats(
    var catImage: String?,
    var catName: String?,
    var catBreed: String?,
    var catSex: String?,
    var catSize: String?,
    var catBreedDetails: String,
) : Parcelable