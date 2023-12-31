@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
}

android {
    namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.LIST_MODULE}"
    compileSdk = configuration.ConfigData.compileSdkVersion

    defaultConfig {
        namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.LIST_MODULE}"
        minSdk = configuration.ConfigData.minSdkVersion
        targetSdk =  configuration.ConfigData.targetSdk
        versionCode = configuration.ConfigData.versionCode
        versionName = configuration.ConfigData.versionName

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
}

dependencies {
    implementation(libs.androidx.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.android.material)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
    androidTestImplementation(libs.androidx.test.espresso)
}