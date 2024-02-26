package com.nels.master.rickandmortydemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.nels.master.MainViewModel
import com.nels.master.rickandmortydemo.ui.screens.MainScreen
import com.nels.master.rickandmortydemo.ui.theme.RickAndMortyDemoTheme

class MainActivity : ComponentActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val splashScreen = installSplashScreen()

        splashScreen.setKeepOnScreenCondition { mainViewModel.uiState.value.data == null }

        setContent {
            RickAndMortyDemoTheme {
               MainScreen(mainViewModel)
            }
        }
    }
}

