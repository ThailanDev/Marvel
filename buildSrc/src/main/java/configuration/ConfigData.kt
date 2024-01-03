package configuration

import org.gradle.api.JavaVersion

object ConfigData {
    const val BASE_NAME = "com.example."
    const val DETAILS_MODULE = "details"
    const val MARVEL_MODULE = "marvel"
    const val CORE_ANDROID_MODULE = "core_android"
    const val CORE_KOTLIN_MODULE = "core_kotlin"
    const val LIST_MODULE = "list"
    const val COLON = ":"
    const val compileSdkVersion = 34
    const val minSdkVersion = 21
    const val targetSdk = 34
    const val versionName = "1.0"
    const val versionCode = 1
    const val jvmTargetVersion = "1.8"
    val sourceCompatibilityVersion = JavaVersion.VERSION_1_8
    val targetCompatibilityVersion = JavaVersion.VERSION_1_8
}
