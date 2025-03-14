package dev.martincaux.property.list.presentation.viewmodel

sealed interface ListIntent {

    data class OnListClicked(val listId: Int) : ListIntent
}
