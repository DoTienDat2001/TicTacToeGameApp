package io.github.yamin8000.dooz.content

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

val Context.settings: DataStore<Preferences> by preferencesDataStore(name = "settings")

class App : Application()