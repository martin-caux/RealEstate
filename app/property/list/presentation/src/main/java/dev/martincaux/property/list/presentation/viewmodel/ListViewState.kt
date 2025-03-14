package dev.martincaux.property.list.presentation.viewmodel

import androidx.compose.runtime.Immutable
import dev.martincaux.property.list.presentation.uimodel.PropertyListUi

@Immutable
sealed class ListViewState {
    data object Loading : ListViewState()
    data class Success(val propertyList: PropertyListUi) : ListViewState()
    data class Error(val message: String) : ListViewState()
}