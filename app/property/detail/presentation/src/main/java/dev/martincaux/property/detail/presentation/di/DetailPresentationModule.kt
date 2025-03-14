package dev.martincaux.property.detail.presentation.di

import co.touchlab.kermit.Logger
import dev.martincaux.property.detail.presentation.viewmodel.DetailViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val detailPresentationModule = module {

    single<Logger> { Logger }

    viewModelOf(::DetailViewModel)

}