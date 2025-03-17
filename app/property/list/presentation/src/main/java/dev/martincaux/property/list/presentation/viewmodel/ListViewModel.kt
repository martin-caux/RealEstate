package dev.martincaux.property.list.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import dev.martincaux.core.navigation.Route
import dev.martincaux.property.list.domain.model.ListDomain
import dev.martincaux.property.list.domain.usecase.GetListUseCase
import dev.martincaux.property.list.presentation.mapper.toUi
import dev.martincaux.property.list.presentation.uimodel.PropertyListUi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(logger: Logger, private val getList: GetListUseCase) : ViewModel() {

    private val log = logger.withTag("ListViewModel")

    private val _viewState = MutableStateFlow<ListViewState>(ListViewState.Loading)
    val viewState = _viewState.asStateFlow()

    private val _navigationEvent = MutableSharedFlow<String>()
    val navigationEvent = _navigationEvent.asSharedFlow()

    init {
        viewModelScope.launch {
            _viewState.value = ListViewState.Loading
            delay(1000)
            getList().onSuccess { properties ->
                _viewState.value = ListViewState.Success(properties)
            }.onFailure { exception ->
                _viewState.value = ListViewState.Error("Failure fetching list")
                log.d { "Failure fetching list : $exception" }
            }
        }
    }

    fun onIntent(intent: ListIntent) {
        when (intent) {
            is ListIntent.OnListClicked -> {
                log.d { "List item clicked ${intent.listId}" }
                viewModelScope.launch {
                    _navigationEvent.emit(Route.RealEstateDetail.createRoute(intent.listId))
                }
            }
        }
    }

    fun propertyListToUi(listDomain: ListDomain, context: Context): PropertyListUi =
        listDomain.toUi(context)
}

