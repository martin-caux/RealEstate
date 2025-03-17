package dev.martincaux.property.detail.presentation.viewmodel

import androidx.compose.runtime.Immutable
import dev.martincaux.property.detail.domain.model.DetailDomain

@Immutable
sealed class DetailViewState {
    data object Loading : DetailViewState()
    data class Success(val property: DetailDomain) : DetailViewState()
    data class Error(val message: String) : DetailViewState()
}