plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "dev.martincaux.listing.list.presentation"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {

    androidTestImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.junit)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.foundation.layout)
    implementation(libs.androidx.ui.text)
    implementation(libs.androidx.ui.unit)
    api(libs.androidx.foundation)
    api(libs.androidx.runtime)

    api(libs.lifecycle.viewmodel)

    api(libs.kotlinx.coroutines.core)

    implementation(libs.kermit)

    implementation(libs.koin.core.viewmodel)
    api(libs.koin.core)

    debugImplementation(libs.ui.tooling)

    implementation(project(":app:core:components"))
    implementation(project(":app:core:navigation"))
    implementation(project(":app:core:theme"))
    implementation(project(":app:core:utils"))
    implementation(project(":app:core:values"))
    api(project(":app:property:common"))
    api(project(":app:property:list:domain"))
}