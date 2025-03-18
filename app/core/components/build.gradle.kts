plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "dev.martincaux.core.components"
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

    implementation(libs.androidx.foundation)
    implementation(libs.androidx.ui.geometry)
    implementation(libs.androidx.ui.text)
    implementation(libs.androidx.ui.unit)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui.tooling.preview.android)
    implementation(libs.androidx.material.icons.core.android)
    api(libs.androidx.foundation.layout)
    api(libs.androidx.runtime)
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)

    implementation(libs.animation.core)

    debugImplementation(libs.ui.tooling)

    implementation(project(":app:core:theme"))
    implementation(project(":app:core:values"))
}