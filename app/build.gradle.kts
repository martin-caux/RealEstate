plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.dependency.analysis)
}

android {
    namespace = "dev.martincaux.realestate"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.martincaux.realestate"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.navigation.compose)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugRuntimeOnly(libs.androidx.ui.test.manifest)

    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)

    implementation(project(":app:core:navigation"))
    implementation(project(":app:core:data"))
    implementation(project(":app:core:theme"))
    implementation(project(":app:property:list:data"))
    implementation(project(":app:property:list:domain"))
    implementation(project(":app:property:list:presentation"))
    implementation(project(":app:property:detail:data"))
    implementation(project(":app:property:detail:domain"))
    implementation(project(":app:property:detail:presentation"))
}