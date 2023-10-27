package io.github.yamin8000.dooz.util

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.saveable.Saver

@Stable
class StableHolder<T>(val item: T) {
    operator fun component1(): T = item
}

@Immutable
class ImmutableHolder<T>(val item: T) {
    operator fun component1(): T = item
}

fun <T : Any> getImmutableHolderSaver(): Saver<ImmutableHolder<T>, T> = Saver(
    save = { it.item },
    restore = { ImmutableHolder(it) }
)

fun <T : Any> getStableHolderSaver(): Saver<StableHolder<T>, T> = Saver(
    save = { it.item },
    restore = { StableHolder(it) }
)