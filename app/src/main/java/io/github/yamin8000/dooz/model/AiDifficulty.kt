package io.github.yamin8000.dooz.model

import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.compose.material.ContentAlpha.medium
import io.github.yamin8000.dooz.R
import kotlinx.parcelize.Parcelize

@Parcelize
enum class AiDifficulty(
    @StringRes val persianNameStringResource: Int
) : Parcelable {
    Easy(R.string.easy), Medium(R.string.medium), Hard(R.string.hard)
}
