package dev.martincaux.property.list.presentation.di

import co.touchlab.kermit.Logger
import dev.martincaux.property.list.presentation.viewmodel.ListViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val listPresentationModule = module {

    single<Logger> { Logger }

    viewModelOf(::ListViewModel)

}