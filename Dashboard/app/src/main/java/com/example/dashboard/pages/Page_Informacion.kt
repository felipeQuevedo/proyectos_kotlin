package com.example.dashboard.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun Page_Informacion() {
    Column() {
        Text(
            text = "Informacion",
            style = MaterialTheme.typography.h2
            )
    }
}