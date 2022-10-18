package view

import BoardIndex
import ViewModel
import androidx.compose.animation.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameScreen(viewModel: ViewModel) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(viewModel.state.size * viewModel.state.size) { index ->
                Button(onClick = { viewModel.doOnclickInGame(index) }) {
                    Text(
                        text = if (BoardIndex(index / viewModel.state.size, index % viewModel.state.size) in listOf(
                                viewModel.state.cell1Index,
                                viewModel.state.cell2Index
                            )
                        ) {
                            viewModel.state.board.board[index / viewModel.state.size][index % viewModel.state.size]
                        } else if (viewModel.state.board.boardIsCellOpened[index / viewModel.state.size][index % viewModel.state.size]) {
                            viewModel.state.board.board[index / viewModel.state.size][index % viewModel.state.size]
                        } else {
                            ""
                        }
                    )
                }
            }
        }
    )
}
