import configuration.ConfigData

@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
    alias(libs.plugins.androidx.navigation.safeargs.kotlin)
}

android {
    namespace = "${ConfigData.BASE_NAME}${ConfigData.DETAILS_MODULE}"
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
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
    implementation(project(":core-android"))
    implementation(libs.bundles.common)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
    implementation(libs.bundles.lifecycle)
    implementation(libs.bundles.navigation)
    implementation(libs.bundles.koin)
    implementation(libs.bundles.retrofit)
    implementation(libs.bundles.fragment)
    implementation(libs.bundles.arrow)
    implementation(libs.bundles.midia)
}