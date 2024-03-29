@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
}

android {
    namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.CORE_ANDROID_MODULE}"
    compileSdk = configuration.ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = configuration.ConfigData.minSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = configuration.ConfigData.sourceCompatibilityVersion
        targetCompatibility = configuration.ConfigData.targetCompatibilityVersion
    }
    kotlinOptions {
        jvmTarget = configuration.ConfigData.jvmTargetVersion
    }
}

dependencies {
    implementation(libs.bundles.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.koin)
}