package dev.martincaux.property.list.presentation.viewmodel

sealed interface ListIntent {

    data class OnListClicked(val listId: Int) : ListIntent
    data object OnListRefresh : ListIntent
    data object OnListRetry : ListIntent
}
