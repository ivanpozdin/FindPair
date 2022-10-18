package view

import ViewModel
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun View(viewModel: ViewModel) {
    MaterialTheme {
        GameScreen((viewModel))
    }
}
