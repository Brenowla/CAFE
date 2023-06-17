package com.example.cafe.common.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import com.example.cafe.common.theme.CAFETheme
import com.example.cafe.login.ui.screen.LoginScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CAFETheme() {
                Scaffold {
                    LoginScreen()
                }
            }
        }
    }
}
