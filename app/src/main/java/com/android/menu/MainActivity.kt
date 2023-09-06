package com.android.menu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.android.menu.navigation.BottomNavigationBar
import com.android.menu.navigation.Navigation
import com.android.menu.ui.theme.MenuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MenuTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController = navController) },
                ) { padding ->

                    Column(
                        modifier = Modifier
                            .padding(padding)
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}