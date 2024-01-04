import configuration.ConfigData

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
    alias(libs.plugins.androidx.navigation.safeargs.kotlin)
}

android {
    namespace = "${ConfigData.BASE_NAME}${ConfigData.MARVEL_MODULE}"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        applicationId = "${ConfigData.BASE_NAME}${ConfigData.MARVEL_MODULE}"
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

    buildFeatures{
        viewBinding = true
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
    implementation(project(":list"))
    implementation(project(":core-android"))
    implementation(libs.bundles.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.koin)
}