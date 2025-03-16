package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.martincaux.core.components.TopNavigationBar
import dev.martincaux.property.list.presentation.viewmodel.ListIntent
import dev.martincaux.property.list.presentation.viewmodel.ListViewModel
import dev.martincaux.property.list.presentation.viewmodel.ListViewState

@Composable
fun ListScreen(modifier: Modifier, viewModel: ListViewModel, onItemClick: (String) -> Unit) {

    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(true) {
        viewModel.navigationEvent.collect { routeUri ->
            onItemClick(routeUri)
        }
    }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopNavigationBar(title = "Properties") }) { innerPadding ->
        when (viewState) {
            is ListViewState.Loading -> {
                List(isLoading = true, modifier = modifier.padding(innerPadding)) { }
            }

            is ListViewState.Success -> {
                val successViewState = viewState as ListViewState.Success
                val propertyList = successViewState.propertyList
                List(propertyList = propertyList, onItemClick = { itemId ->
                    viewModel.onIntent(ListIntent.OnListClicked(itemId))
                }, modifier = modifier.padding(innerPadding))
            }

            is ListViewState.Error -> {
                val errorMessage = (viewState as ListViewState.Error).message
                // Display the error message here
                Text(text = "Error: $errorMessage", modifier = Modifier.padding(16.dp))
            }
        }
    }
}






