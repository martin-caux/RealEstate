package dev.martincaux.property.list.presentation.viewmodel

import androidx.compose.runtime.Immutable
import dev.martincaux.property.list.domain.model.ListDomain

@Immutable
sealed class ListViewState {
    data object Loading : ListViewState()
    data class Success(val propertyList: ListDomain) : ListViewState()
    data object Empty : ListViewState()
    data class Error(val message: String) : ListViewState()
}