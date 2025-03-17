package dev.martincaux.property.detail.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import dev.martincaux.core.components.ErrorScreen
import dev.martincaux.core.components.TopNavigationBar
import dev.martincaux.property.common.compose.PropertyCard
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewModel
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewState

@Composable
fun DetailScreen(modifier: Modifier, viewModel: DetailViewModel, onNavigateUp: () -> Unit) {

    val viewState by viewModel.viewState.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopNavigationBar(onNavigateUp = onNavigateUp, isTransparent = true) }
    ) { innerPadding ->
        when (viewState) {
            is DetailViewState.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is DetailViewState.Success -> {
                val successViewState = viewState as DetailViewState.Success
                PropertyCard(
                    property = viewModel.propertyDetailToUi(
                        detailDomain = successViewState.property,
                        context = LocalContext.current
                    )
                )
            }

            is DetailViewState.Error -> {
                val errorMessage = (viewState as DetailViewState.Error).message
                ErrorScreen(errorMessage) { }
            }
        }
    }
}






