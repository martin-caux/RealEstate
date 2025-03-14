package dev.martincaux.property.detail.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.martincaux.property.common.compose.PropertyCard
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewModel
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewState

@Composable
fun DetailScreen(modifier: Modifier, viewModel: DetailViewModel) {

    val viewState by viewModel.viewState.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        when (viewState) {
            is DetailViewState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }

            is DetailViewState.Success -> {
                val successViewState = viewState as DetailViewState.Success
                PropertyCard(successViewState.property)
            }

            is DetailViewState.Error -> {
                val errorMessage = (viewState as DetailViewState.Error).message
                // Display the error message here
                Text(text = "Error: $errorMessage", modifier = Modifier.padding(16.dp))
            }
        }
    }
}






