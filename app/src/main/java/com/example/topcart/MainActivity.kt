package com.example.topcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.topcart.navigation.AppNavHost
import com.example.topcart.navigation.AppNavigationBar
import com.example.topcart.ui.theme.TopCartTheme

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopCartTheme {
                Scaffold(
                    containerColor = MaterialTheme.colorScheme.background,
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        AppNavigationBar()
                    }
                ) { paddingValues ->
                    AppNavHost(modifier = Modifier.padding(paddingValues))
                }
            }
        }
    }
}