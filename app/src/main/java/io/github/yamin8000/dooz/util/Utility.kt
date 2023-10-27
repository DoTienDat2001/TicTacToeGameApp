package io.github.yamin8000.dooz.util

import android.content.Context
import android.util.Log
import io.github.yamin8000.dooz.BuildConfig
import java.util.Locale

object Utility {

    private fun getCurrentLocale(context: Context): Locale =
        context.resources.configuration.locales.get(0)

    //simple 90 degrees rotation
    fun <T> List<List<T>>.rotated(): List<List<T>> {
        val rotated = mutableListOf<List<T>>()

        for (j in this.indices) {
            val newRow = mutableListOf<T>()
            for (i in this.indices)
                newRow.add(this[i][j])
            rotated.add(newRow.reversed())
        }

        return rotated
    }

    fun <T> List<List<T>>.diagonals(): Pair<List<T>, List<T>> {
        return this.diagonal() to this.rotated().diagonal()
    }

    private fun <T> List<List<T>>.diagonal(): List<T> {
        val diagonal = mutableListOf<T>()
        for (i in this.indices)
            diagonal.add(this[i][i])
        return diagonal
    }

    fun Context.isLocalePersian(text: String): Boolean {
        val currentLocale = getCurrentLocale(this).language
        return currentLocale == Locale("fa").language || Constants.PERSIAN_REGEX.containsMatchIn(
            text
        )
    }

    fun log(
        message: String
    ) {
        if (BuildConfig.DEBUG)
            Log.d(Constants.LOG_TAG, message)
    }

    fun log(
        exception: Exception
    ) {
        log(exception.stackTraceToString())
    }
}