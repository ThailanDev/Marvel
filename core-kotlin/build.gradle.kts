@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.org.jetbrains.kotlinandroid)
}

android {
    namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.CORE_KOTLIN_MODULE}"
    compileSdk = configuration.ConfigData.compileSdkVersion
    defaultConfig {
        namespace = "${configuration.ConfigData.BASE_NAME}${configuration.ConfigData.CORE_KOTLIN_MODULE}"
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext)
}