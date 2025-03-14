package dev.martincaux.realestate

import android.app.Application
import dev.martincaux.core.data.di.coreDataModule
import dev.martincaux.property.detail.data.di.detailDataModule
import dev.martincaux.property.detail.domain.di.detailDomainModule
import dev.martincaux.property.detail.presentation.di.detailPresentationModule
import dev.martincaux.property.list.data.di.listDataModule
import dev.martincaux.property.list.domain.di.listDomainModule
import dev.martincaux.property.list.presentation.di.listPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@MainApplication)
            // Load modules
            modules(
                coreDataModule,
                listPresentationModule,
                listDomainModule,
                listDataModule,
                detailDomainModule,
                detailDataModule,
                detailPresentationModule
            )
        }
    }

}