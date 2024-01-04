@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.com.android.library)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
}

android {
    namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.LIST_MODULE}"
    compileSdk = configuration.ConfigData.compileSdkVersion

    defaultConfig {
        namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.LIST_MODULE}"
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
    compileOptions {
        sourceCompatibility = configuration.ConfigData.sourceCompatibilityVersion
        targetCompatibility = configuration.ConfigData.targetCompatibilityVersion
    }

    kotlinOptions {
        jvmTarget = configuration.ConfigData.jvmTargetVersion
    }

    buildFeatures {
        viewBinding = true
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
}