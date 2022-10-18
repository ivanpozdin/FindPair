import androidx.compose.runtime.*
import game.Board

class ViewModel(val n: Int) {
    var state: State by mutableStateOf(initialState())
        private set

    data class State(
        var size: Int,
        var board: Board = Board(size),
        var amountOfOpenedCells: Int = 0,
        var cell1Index: BoardIndex? = null,
        var cell2Index: BoardIndex? = null,

    )

    private fun initialState(): State = State(size = n)

    private inline fun updateState(update: State.() -> State) {
        state = state.update()
    }

    fun doOnclickInGame(index: Int) = updateState {
        if (board.boardIsCellOpened[index/size][index%size]){
            copy()
        } else {
            var openedCells = 0
            val cell1: BoardIndex?
            val cell2: BoardIndex?
            if (amountOfOpenedCells == 0) {
                openedCells = 1
                cell1 = BoardIndex(index / size, index % size)
                cell2 = null
            } else if (amountOfOpenedCells == 1) {
                openedCells = 2
                cell1 = cell1Index
                cell2 = BoardIndex(index / size, index % size)
                if ((cell1 != null) && (board.board[cell1.row][cell1.column] == board.board[cell2.row][cell2.column])) {
                    board.boardIsCellOpened[cell1.row][cell1.column] = true
                    board.boardIsCellOpened[cell2.row][cell2.column] = true
                }
            } else {
                cell1 = null
                cell2 = null
            }
            copy(cell1Index = cell1, cell2Index = cell2, amountOfOpenedCells = openedCells)
        }
    }
}
