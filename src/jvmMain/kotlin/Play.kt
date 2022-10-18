// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import view.View

fun play(size: Int) = application {
    Window(
        onCloseRequest = ::exitApplication, title = "FindPair", resizable = false,
        state = rememberWindowState(width = 600.dp, height = 600.dp)
    ) {
        val viewModel = remember { ViewModel(size) }
        View(viewModel)
    }
}

