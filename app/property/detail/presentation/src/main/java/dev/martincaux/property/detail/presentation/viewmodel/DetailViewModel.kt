package dev.martincaux.property.detail.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import dev.martincaux.property.detail.domain.GetDetailUseCase
import dev.martincaux.property.detail.presentation.mapper.toUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    logger: Logger,
    private val itemId: Int,
    private val getDetail: GetDetailUseCase
) : ViewModel() {

    private val log = logger.withTag("DetailViewModel")

    private val _viewState = MutableStateFlow<DetailViewState>(DetailViewState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.value = DetailViewState.Loading
            getDetail(itemId = itemId).onSuccess { detail ->
                _viewState.value = DetailViewState.Success(detail.toUi())
            }.onFailure { exception ->
                _viewState.value = DetailViewState.Error("Failure fetching detail")
                log.d { "Failure fetching detail : $exception" }
            }
        }
    }
}

