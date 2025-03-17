package dev.martincaux.property.detail.presentation.viewmodel

sealed interface DetailIntent {
    data object OnDetailRetry : DetailIntent
}
