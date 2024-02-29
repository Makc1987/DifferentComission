
fun main() {
    var sumDay = 0
    var sumMonth = 0
    var type = "MIR"
    println("Введите сумму перевода: ")
    val amount = readln().toInt()
    transfer(type, sumDay, sumMonth, amount)
}
fun limitCheck(amount: Int, sumDay: Int, sumMonth: Int): Boolean {
    val limitDay = 150_000
    val limitMonth = 600_000
    if (amount + sumDay > limitDay) return false
    if (amount + sumMonth > limitMonth) return false
    return true
}
fun mir(amount: Int) {
    println("Сумма перевода: $amount. Размер комиссии: 0 руб.")
}
fun visa(amount: Int) {
    val comission = 0.75
    val minComission = 35
    val result = amount * comission / 100
    val totalComission = if (result > minComission) result else minComission
    println("Сумма перевода: $amount. Размер комиссии за перевод: $totalComission руб.")
}
fun mastercard(amount: Int, sumMonth: Int) {
    val monthLimit = 75_000
    val comission = 0.006
    var result = 0
    if (amount+sumMonth > monthLimit) result = (amount*comission).toInt() + 20
    println("Сумма перевода: $amount. Размер комиссии за перевод: $result руб.")
}
fun transfer(type: String, sumDay: Int, sumMonth: Int, amount: Int) {
    if (!limitCheck(amount, sumDay, sumMonth))
        println("Перевод невозможен, превышены лимиты!")
    when(type) {
        "MIR" -> mir(amount)
        "VISA" -> visa(amount)
        "MASTERCARD" -> mastercard(amount, sumMonth)
        else -> println("Неизвестный тип карты.")
    }

}