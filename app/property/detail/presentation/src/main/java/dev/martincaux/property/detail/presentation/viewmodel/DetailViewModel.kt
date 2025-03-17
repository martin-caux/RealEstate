package dev.martincaux.property.detail.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import dev.martincaux.property.common.uimodel.PropertyItemUi
import dev.martincaux.property.detail.domain.model.DetailDomain
import dev.martincaux.property.detail.domain.usecase.GetDetailUseCase
import dev.martincaux.property.detail.presentation.mapper.toUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailViewModel(
    logger: Logger, private val itemId: Int, private val getDetail: GetDetailUseCase
) : ViewModel() {

    private val log = logger.withTag("DetailViewModel")

    private val _viewState = MutableStateFlow<DetailViewState>(DetailViewState.Loading)
    val viewState = _viewState.asStateFlow()

    init {
        viewModelScope.launch {
            _viewState.value = DetailViewState.Loading
            fetchDetail()
        }
    }

    fun onIntent(intent: DetailIntent) {
        when (intent) {
            DetailIntent.OnDetailRetry -> {
                viewModelScope.launch {
                    _viewState.value = DetailViewState.Loading
                    fetchDetail()
                }
            }
        }
    }

    private suspend fun fetchDetail() {
        getDetail(itemId = itemId).onSuccess { detail ->
            delay(1000)
            _viewState.value = DetailViewState.Success(detail)
        }.onFailure { exception ->
            _viewState.value = DetailViewState.Error("$exception")
            log.d { "$exception" }
        }
    }

    fun propertyDetailToUi(detailDomain: DetailDomain, context: Context): PropertyItemUi =
        detailDomain.toUi(context)
}

