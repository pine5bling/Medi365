package com.thomnt.medi365.navigation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController

class NavigationManager(private val activity: AppCompatActivity, private val navHostFragmentId: Int) {
//    private val navController by lazy { controller() }
//
//    fun controller(): NavController {
//        val navHostFragment = activity.supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
//        return navHostFragment.findNavController()
//    }
    private val navController by lazy { controller(navHostFragmentId) }

    fun controller(navHostFragmentId: Int): NavController {
        val navHostFragment = activity.supportFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
        return navHostFragment.findNavController()
    }

    // chuyển đến màn hình khác
    fun navigateTo(
        @IdRes resId: Int,
        args: Bundle? = null,
//        navOptions: NavOptions? = getUpNavOptions()
    ) {
//        navController.navigate(resId, args, navOptions)
    }

    // trở lại màn hình trước đó
    fun popBackStack(resId: Int, inclusive: Boolean = false): Boolean {
        return navController.popBackStack(resId, inclusive)
    }

    // trở lại màn hình trước đó
    fun backScreen(): Boolean {
        return navController.navigateUp()
    }
}
