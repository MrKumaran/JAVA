/*
Printing Message
fun main(){
    println("Use the val keyword when the value doesn't change. \n" +
            "Use the var keyword when the value can change.\n" +
            "When you define a function, you define the parameters that can be passed to it. \n" +
            "When you call a function, you pass arguments for the parameters.")
}
*/

/*
Error Debugging

With Error

fun main() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = "$baseSalary + $bonusAmount"
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}


Error Free

fun main() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = baseSalary + bonusAmount
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}

------------------------------------------------------------------------------------------------------------------------

With Error
fun main() {
    val numberOfAdults = "20"
    val numberOfKids = "30"
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}


Error Free

fun main() {
    val numberOfAdults = "20"
    val numberOfKids = "30"
    val total = numberOfAdults.toInt() + numberOfKids.toInt() // Type Conversion
    println("The total party size is: $total")
}

------------------------------------------------------------------------------------------------------------------------

With Error
fun main() {
    val discountPercentage: Int = 0
    val offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"

    println(offer)
}


Error Free
fun main() {
    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    println(offer)
}

------------------------------------------------------------------------------------------------------------------------

With Error
fun main() {
    println("New chat message from a friend'} <-
}


Error Free
fun main() {
    println("New chat message from a friend')
}

*/