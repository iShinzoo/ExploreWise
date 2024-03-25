plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.googleAndroidLibrariesMapsplatformSecretsGradlePlugin)
}

android {
    namespace = "com.example.explorewise"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.explorewise"
        minSdk = 22
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.play.services.maps)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.tv.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // System Ui Controller
    implementation ("com.google.accompanist:accompanist-systemuicontroller:0.34.0")

    //material icon extended library
    implementation ("androidx.compose.material:material-icons-extended:1.7.0-alpha05")

    // Compose Navigation
    implementation ("androidx.navigation:navigation-compose:2.8.0-alpha05")

    // Google maps
    implementation ("com.google.maps.android:maps-compose:4.3.3")
    implementation ("com.google.maps.android:maps-compose-utils:4.3.3")

    // new Splash Screen API
    implementation ("androidx.core:core-splashscreen:1.1.0-alpha02")

    // kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.0-alpha03")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.0-alpha03")

    // pager
    implementation ("com.google.accompanist:accompanist-pager:0.34.0")

    // carousel
    implementation ("com.google.android.material:material:1.11.0")

    // coil library for image
    implementation("io.coil-kt:coil-compose:2.6.0")

    implementation ("androidx.compose.material3:material3:1.2.1")
    implementation ("androidx.compose.ui:ui:1.6.4")
    implementation ("androidx.compose.ui:ui-tooling:1.6.4")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.6.4")
}