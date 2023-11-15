package com.example.rako.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

open class CCheckBoxState(
    private val initialState: Boolean = false,
) {

    var isChecked: Boolean by mutableStateOf(initialState)
}