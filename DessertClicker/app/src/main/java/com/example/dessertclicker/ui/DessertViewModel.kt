package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(PostreUiState())
    val uiState: StateFlow<PostreUiState> = _uiState.asStateFlow()


    fun alHacerClicEnPostre() {
        _uiState.update { cupcakeUiState ->
            val postresVendidos = cupcakeUiState.postresVendidos + 1
            val siguienteIndicePostre = determinarIndicePostre(postresVendidos)
            cupcakeUiState.copy(
                indiceActualPostre = siguienteIndicePostre,
                ingresos = cupcakeUiState.ingresos + cupcakeUiState.precioActualPostre,
                postresVendidos = postresVendidos,
                idImagenActualPostre = dessertList[siguienteIndicePostre].imageId,
                precioActualPostre = dessertList[siguienteIndicePostre].price
            )
        }
    }

    private fun determinarIndicePostre(postresVendidos: Int): Int {
        var indicePostre = 0
        for (indice  in dessertList.indices) {
            if (postresVendidos >= dessertList[indice ].startProductionAmount) {
                indicePostre = indice
            } else {
                break
            }
        }
        return indicePostre
    }
}