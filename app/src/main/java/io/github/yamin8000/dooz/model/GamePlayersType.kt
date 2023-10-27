package io.github.yamin8000.dooz.model

import android.os.Parcelable
import androidx.annotation.StringRes
import io.github.yamin8000.dooz.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class GamePlayersType(
    @StringRes val persianNameStringResource: Int
) : Parcelable {
    PvP(R.string.play_with_human), PvC(R.string.play_with_computer);
}