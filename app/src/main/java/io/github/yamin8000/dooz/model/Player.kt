package io.github.yamin8000.dooz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//unstable
@Parcelize
data class Player(
    val name: String,
    val shape: String? = null,
    var diceIndex: Int = 0,
    val type: PlayerType = PlayerType.Human
) : Parcelable