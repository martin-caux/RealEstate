package dev.martincaux.property.detail.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import dev.martincaux.core.components.ErrorScreen
import dev.martincaux.core.components.TopNavigationBar
import dev.martincaux.property.common.compose.PropertyCard
import dev.martincaux.property.common.compose.PropertyCardLoading
import dev.martincaux.property.detail.presentation.viewmodel.DetailIntent
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewModel
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailScreen(modifier: Modifier, viewModel: DetailViewModel, onNavigateUp: () -> Unit) {

    val viewState by viewModel.viewState.collectAsState()
    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = { TopNavigationBar(onNavigateUp = onNavigateUp, isTransparent = true) }) { _ ->
        when (viewState) {
            is DetailViewState.Loading -> {
                PropertyCardLoading()
            }

            is DetailViewState.Success -> {
                val successViewState = viewState as DetailViewState.Success
                PropertyCard(property = successViewState.property)
            }

            is DetailViewState.Error -> {
                val errorMessage = (viewState as DetailViewState.Error).message
                ErrorScreen(errorMessage) {
                    viewModel.onIntent(DetailIntent.OnDetailRetry)
                }
            }
        }
    }
}