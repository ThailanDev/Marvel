package com.example.navigation

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigator

fun NavController.navigateUriWithDefaultOptions(
    uri: Uri,
    extras: FragmentNavigator.Extras? = null,
    enterAnimation: Int? = null,
    exitAnimation: Int? = null,
    popEnterAnimation: Int? = null,
    popExitAnimation: Int? = null,
    isInclusive: Boolean = false,
    popUpTo: Int = 0,
    launchSingleTop: Boolean = false
) {
    try {
        this.navigate(
            uri,
            createDefaultNavOptions(
                destination = popUpTo,
                enterAnimation = enterAnimation ?: 0,
                exitAnimation = exitAnimation ?: 0,
                popEnterAnimation = popEnterAnimation ?: 0,
                popExitAnimation = popExitAnimation ?: 0,
                isInclusive = isInclusive,
                launchSingleTop = launchSingleTop
            ),
            extras
        )
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

fun createDefaultNavOptions(
    destination: Int,
    enterAnimation: Int,
    exitAnimation: Int,
    popEnterAnimation: Int,
    popExitAnimation: Int,
    isInclusive: Boolean,
    launchSingleTop: Boolean = false,
) = NavOptions.Builder()
    .setLaunchSingleTop(launchSingleTop)
    .setLaunchSingleTop(false)
    .setPopUpTo(destination, isInclusive)
    .setEnterAnim(enterAnimation)
    .setExitAnim(exitAnimation)
    .setPopEnterAnim(popEnterAnimation)
    .setPopExitAnim(popExitAnimation)
    .build()