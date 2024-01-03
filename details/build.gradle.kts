import configuration.ConfigData

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
}

android {
    namespace = "${ConfigData.BASE_NAME}${ConfigData.DETAILS_MODULE}"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId =  "${ConfigData.BASE_NAME}${ConfigData.DETAILS_MODULE}"
        minSdk = ConfigData.minSdkVersion
        targetSdk =  ConfigData.targetSdk
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName
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
    compileOptions {
        sourceCompatibility = ConfigData.sourceCompatibilityVersion
        targetCompatibility = ConfigData.targetCompatibilityVersion
    }
    kotlinOptions {
        jvmTarget = ConfigData.jvmTargetVersion
    }
}

dependencies {
    implementation(libs.bundles.common)
    implementation(libs.androidx.navigation.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    // aí aqui duplica com a do libs.androidx.navigation.navigation.fragment.ktx e do libs.androidx.navigation.navigation.ui.ktx
//    implementation(libs.bundles.navigation)
    implementation(libs.bundles.lifecycle)
}