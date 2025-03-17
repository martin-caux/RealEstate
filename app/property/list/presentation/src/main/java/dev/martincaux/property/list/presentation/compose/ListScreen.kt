package dev.martincaux.property.list.presentation.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import dev.martincaux.core.components.ErrorScreen
import dev.martincaux.core.components.TopNavigationBar
import dev.martincaux.property.common.compose.EmptyScreen
import dev.martincaux.property.list.presentation.viewmodel.ListIntent
import dev.martincaux.property.list.presentation.viewmodel.ListViewModel
import dev.martincaux.property.list.presentation.viewmodel.ListViewState
import dev.martincaux.core.values.R as CoreValuesR

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(modifier: Modifier, viewModel: ListViewModel, onItemClick: (String) -> Unit) {

    val viewState by viewModel.viewState.collectAsState()

    LaunchedEffect(true) {
        viewModel.navigationEvent.collect { routeUri ->
            onItemClick(routeUri)
        }
    }

    val pullToRefreshState = rememberPullToRefreshState()

    Scaffold(modifier = modifier.fillMaxSize(),
        topBar = { TopNavigationBar(title = stringResource(CoreValuesR.string.list_screen_title)) }
    ) { innerPadding ->

        when (viewState) {
            is ListViewState.Loading -> {
                List(isLoading = true, modifier = modifier.padding(innerPadding)) { }
            }

            is ListViewState.Success -> {
                val successViewState = viewState as ListViewState.Success
                val propertyList = successViewState.propertyList
                PullToRefreshBox(
                    modifier = modifier.padding(innerPadding),
                    isRefreshing = successViewState.isRefreshing,
                    state = pullToRefreshState,
                    onRefresh = {
                        viewModel.onIntent(ListIntent.OnListRefresh)
                    }
                ) {
                    List(
                        propertyList = viewModel.propertyListToUi(
                            listDomain = propertyList, context = LocalContext.current
                        ), onItemClick = { itemId ->
                            viewModel.onIntent(ListIntent.OnListClicked(itemId))
                        }
                    )
                }
            }

            ListViewState.Empty -> {
                EmptyScreen()
            }

            is ListViewState.Error -> {
                val errorMessage = (viewState as ListViewState.Error).message
                ErrorScreen(message = errorMessage) { viewModel.onIntent(ListIntent.OnListRefresh) }
            }
        }
    }
}








