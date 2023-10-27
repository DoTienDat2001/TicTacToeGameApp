package io.github.yamin8000.dooz.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class PlayerType : Parcelable {
    Human, Computer
}
