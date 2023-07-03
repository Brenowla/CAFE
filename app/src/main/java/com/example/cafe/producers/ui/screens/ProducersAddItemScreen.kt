package com.example.cafe.producers.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.cafe.common.theme.CafeTheme
import com.example.cafe.common.theme.CafeTheme.colors
import com.example.cafe.common.theme.CafeTheme.spacing
import com.example.cafe.common.theme.CafeTheme.typography
import com.example.cafe.common.ui.components.CafeButton
import com.example.cafe.common.ui.components.CafeEditTextField
import com.example.cafe.common.ui.utils.setLoading
import com.example.cafe.producers.ui.viewmodels.ProducersAddItemViewModel
import com.example.cafe.products.constants.ProductsTypeEnum

@Composable
fun ProducersAddItemScreen(
    viewModel: ProducersAddItemViewModel = hiltViewModel(),
    snackbarHostState: SnackbarHostState = SnackbarHostState()
) {
    val context = LocalContext.current

    LaunchedEffect(viewModel.loading.value) {
        context.setLoading(viewModel.loading.value)
    }

    LaunchedEffect(viewModel.success.value) {
        if(viewModel.success.value) {
            snackbarHostState.showSnackbar("Item criado com sucesso")
            viewModel.clearFields()
        }
    }

    LaunchedEffect(viewModel.error.value) {
        if(viewModel.error.value) {
            snackbarHostState.showSnackbar("O item não foi criado com sucesso, por favor, tente mais tarde!")
        }
    }

    val galleryOpen =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { imageUri ->
            viewModel.image.value = imageUri
        }
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(state = rememberScrollState())
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height = 50.dp)
                .background(
                    color = colors.primary100, shape = RoundedCornerShape(
                        topStart = 0.dp,
                        topEnd = 0.dp,
                        bottomEnd = spacing.spacing8,
                        bottomStart = spacing.spacing8
                    )
                )
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing4))
        Text(
            text = "Cadastre um novo produto",
            style = typography.heading4,
            modifier = Modifier.padding(horizontal = spacing.spacing4)
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing4))
        CafeEditTextField(
            modifier = Modifier.padding(horizontal = spacing.spacing4),
            value = viewModel.name.value,
            placeholder = "nome",
            onValueChange = { viewModel.name.value = it }
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        CafeEditTextField(
            modifier = Modifier.padding(horizontal = spacing.spacing4),
            value = viewModel.value.value,
            placeholder = "valor",
            keyboardType = KeyboardType.Number,
            onValueChange = { viewModel.value.value = it }
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        CafeEditTextField(
            modifier = Modifier.padding(horizontal = spacing.spacing4),
            value = viewModel.description.value,
            placeholder = "descrição",
            onValueChange = { viewModel.description.value = it }
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        Text(
            modifier = Modifier.padding(horizontal = spacing.spacing4),
            text = "Selecione o tipo de item",
            style = typography.body
        )
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        ProductsTypeEnum.getAll().forEach {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = spacing.spacing4)
                    .clickable {
                        viewModel.type.value = it
                    },
                verticalAlignment = CenterVertically
            ) {
                RadioButton(
                    selected = viewModel.type.value == it,
                    colors = RadioButtonColors(
                        colors.primary100,
                        colors.background,
                        colors.info,
                        colors.secondary200
                    ),
                    onClick = {}
                )
                Text(text = it.title, style = typography.body)
            }
        }
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        CafeButton(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing.spacing4), text = "Adicione uma imagem do item"
        ) {
            galleryOpen.launch("image/*")
        }
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        Box(
            modifier = Modifier
                .padding(horizontal = spacing.spacing4)
                .background(
                    color = colors.background,
                    shape = RoundedCornerShape(size = 8.dp)
                )
                .fillMaxWidth()
                .height(height = 300.dp),
            contentAlignment = Center
        ) {
            if (viewModel.image.value == null) {
                Text(text = "Preview da imagem", style = typography.body, color = colors.muted)
            } else {
                Image(
                    painter = rememberAsyncImagePainter(
                        ImageRequest.Builder(LocalContext.current)
                            .data(data = viewModel.image.value).build()
                    ), contentDescription = null
                )
            }
        }
        Spacer(modifier = Modifier.height(height = spacing.spacing3))
        CafeButton(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = spacing.spacing4), text = "Cadastrar item"
        ) {
            viewModel.saveItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewProducersAddItemScreen() {
    ProducersAddItemScreen()
}