package com.example.cafe.login.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.cafe.R
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.ui.components.CafeButton
import com.example.cafe.common.ui.components.CafeEditTextField
import com.example.cafe.common.ui.utils.setLoading
import com.example.cafe.login.ui.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseUser

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onLogin: (FirebaseUser) -> Unit
) {
    val context = LocalContext.current
    LaunchedEffect(viewModel.loading.value) {
        context.setLoading(viewModel.loading.value)
    }
    LaunchedEffect(viewModel.user.value) {
        viewModel.user.value?.let(onLogin)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spacing8), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(weight = 1f))
        Image(
            modifier = Modifier.size(size = 198.dp),
            painter = painterResource(id = R.drawable.cafe_logo),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing8))
        CafeEditTextField(
            value = viewModel.email.value,
            onValueChange = { viewModel.email.value = it },
            placeholder = "e-mail",
            keyboardType = KeyboardType.Email
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing4))
        CafeEditTextField(
            value = viewModel.password.value,
            onValueChange = { viewModel.password.value = it },
            placeholder = "senha",
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation('*')
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing4))
        CafeButton(modifier = Modifier.fillMaxWidth(), text = "Entrar") {
            viewModel.login()
        }
        Spacer(modifier = Modifier.weight(weight = 1f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen {

    }
}