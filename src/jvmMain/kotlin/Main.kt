fun main() {
    var input = ""
    while (input.toIntOrNull() == null  || input.toInt() % 2 != 0 || input.toInt() <= 0){
        println("Введите число -- размер поля. Число должно быть чётным и больше нуля.")
        input = readln()
    }
    play(input.toInt())
}