package game

class Board(val size: Int = 6) {
    val board = initializeArray()
    val boardIsCellOpened = Array(size) {Array(size) {false} }

    private fun initializeArray(): Array<Array<String>> {
        val listOfNumbers = MutableList(size * size) { it / 2 }
        listOfNumbers.shuffle()

        return Array(size) { row: Int ->
            Array(size) { column: Int -> listOfNumbers[row * size + column].toString() }
        }
    }

}