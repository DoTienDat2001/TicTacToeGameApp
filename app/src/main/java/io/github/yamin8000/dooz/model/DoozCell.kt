package io.github.yamin8000.dooz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DoozCell(
    val x: Int,
    val y: Int,
    var owner: Player? = null
) : Parcelable