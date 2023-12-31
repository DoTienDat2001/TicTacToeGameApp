package io.github.yamin8000.dooz.util

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class DataStoreHelper(
    private val datastore: DataStore<Preferences>
) {

    suspend fun getBoolean(
        key: String
    ) = datastore.data.map {
        it[booleanPreferencesKey(key)]
    }.firstOrNull()

    suspend fun setBoolean(
        key: String,
        value: Boolean
    ) {
        datastore.edit {
            it[booleanPreferencesKey(key)] = value
        }
    }

    suspend fun getString(
        key: String
    ) = datastore.data.map {
        it[stringPreferencesKey(key)]
    }.firstOrNull()

    suspend fun setString(
        key: String,
        value: String
    ) {
        datastore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }

    suspend fun getInt(
        key: String
    ) = datastore.data.map {
        it[intPreferencesKey(key)]
    }.firstOrNull()

    suspend fun setInt(
        key: String,
        value: Int
    ) {
        datastore.edit {
            it[intPreferencesKey(key)] = value
        }
    }
}