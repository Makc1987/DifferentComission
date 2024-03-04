
fun main() {
    println("Введите сумму перевода: ")
    transfer()
}
fun limitCheck(amount: Int, sumMonth: Int): Boolean {
    val limitDay = 150_000
    val limitMonth = 600_000
    if (amount  > limitDay) return false
    if (amount + sumMonth > limitMonth) return false
    return true
}
fun mir(amount: Int): Unit {
    println("Сумма перевода: $amount. Размер комиссии: 0 руб.")
}
fun visa(amount: Int): Unit {
    val comission = 0.75
    val minComission = 35
    val result = amount * comission / 100
    val totalComission = if (result > minComission) result else minComission
    println("Сумма перевода: $amount. Размер комиссии за перевод: $totalComission руб.")
}
fun mastercard(amount: Int, sumMonth: Int): Unit {
    val monthLimit = 75_000
    val comission = 0.006
    var result = 0
    if (sumMonth >= monthLimit) result = (amount*comission).toInt() + 20
    if (amount+sumMonth > monthLimit && sumMonth < monthLimit) result = ((sumMonth + amount - monthLimit) *comission).toInt() + 20
    println("Сумма перевода: $amount. Размер комиссии за перевод: $result руб.")
}
fun transfer(type: String = "MIR", sumMonth: Int = 0, amount: Int = readln().toInt()): Unit {
    if (!limitCheck(amount, sumMonth))
        println("Перевод невозможен, превышены лимиты!")
    when(type) {
        "MIR" -> mir(amount)
        "VISA" -> visa(amount)
        "MASTERCARD" -> mastercard(amount, sumMonth)
        else -> println("Неизвестный тип карты.")
    }

}