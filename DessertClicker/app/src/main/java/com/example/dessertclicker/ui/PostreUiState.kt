package com.example.dessertclicker.ui

import androidx.annotation.DrawableRes
import com.example.dessertclicker.data.Datasource.dessertList

data class PostreUiState (
    val ingresos: Int = 0,
    val postresVendidos: Int = 0,
    val indiceActualPostre: Int = 0,
    val precioActualPostre: Int = dessertList[indiceActualPostre].price,
    @DrawableRes val idImagenActualPostre: Int = dessertList[indiceActualPostre].imageId
)