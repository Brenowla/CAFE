package com.example.cafe.login.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.CafeButton
import com.example.cafe.common.ui.components.CafeButtonStyles
import com.example.cafe.common.ui.components.CafeEditTextField
import com.example.cafe.login.ui.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen(
    viewModel: SignUpViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
    onSignUp: () -> Unit
) {
    LaunchedEffect(viewModel.signUp.value) {
        if(viewModel.signUp.value) {
            onSignUp()
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.15f)
                .background(
                    color = colors.primary100, shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = spacing.spacing8,
                        bottomStart = spacing.spacing8
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(spacing.spacing8)
        ) {
            Spacer(modifier = Modifier.fillMaxHeight(fraction = 0.15f))
            Text(text = "Cadastre-se já", style = typography.heading4)
            Spacer(modifier = Modifier.weight(weight = 1f))
            CafeEditTextField(
                value = viewModel.name.value,
                onValueChange = { viewModel.name.value = it },
                placeholder = "nome completo",
            )
            Spacer(modifier = Modifier.height(height = spacing.spacing4))
            CafeEditTextField(
                value = viewModel.email.value,
                onValueChange = { viewModel.email.value = it },
                placeholder = "email",
                keyboardType = KeyboardType.Email,
            )
            Spacer(modifier = Modifier.height(height = spacing.spacing4))
            CafeEditTextField(
                value = viewModel.phone.value,
                onValueChange = { viewModel.phone.value = it },
                placeholder = "telefone",
                keyboardType = KeyboardType.Phone,
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
            CafeEditTextField(
                value = viewModel.confirmPassword.value,
                onValueChange = { viewModel.confirmPassword.value = it },
                placeholder = "confirme sua senha",
                keyboardType = KeyboardType.Password,
                visualTransformation = PasswordVisualTransformation('*')
            )
            Spacer(modifier = Modifier.height(height = spacing.spacing4))
            Spacer(modifier = Modifier.height(height = spacing.spacing4))
            CafeButton(modifier = Modifier.fillMaxWidth(), text = "Cadastrar") {
                viewModel.signUp()
            }
            Spacer(modifier = Modifier.height(height = spacing.spacing4))
            CafeButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Voltar",
                type = CafeButtonStyles.SECONDARY
            ) {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.weight(weight = 1f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen() {

    }
}