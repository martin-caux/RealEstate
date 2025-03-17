package dev.martincaux.property.detail.presentation.viewmodel

import androidx.compose.runtime.Immutable
import dev.martincaux.property.common.uimodel.PropertyItemUi

@Immutable
sealed class DetailViewState {
    data object Loading : DetailViewState()
    data class Success(val property: PropertyItemUi) : DetailViewState()
    data class Error(val message: String) : DetailViewState()
}