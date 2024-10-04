/*
Keyword <funName> () : returnType{
    body
    return statement
}

Return Type -> Unit refers to void it is optional.
*/

// Main function or driver code
fun main(){
    exampleFunctionOne()
    val exampleTwo: String = exampleFunctionTwo()
    println(exampleTwo)
    val exampleThree: String = exampleFunctionThree("Three")
    println(exampleThree)
    val exampleFour: String = exampleFunctionFour(Text = "Message", number = "Four")
    println(exampleFour)
    val exampleFive: String = exampleFunctionFive() // Default Argument has String "Five" so no need to pass unless we want to change it
    println(exampleFive)
    val exampleSix: String = exampleFunctionFive("Six") // Passing argument to default argument function change the argument value
    println(exampleSix)
}

// An example function
fun exampleFunctionOne(): Unit{
    println("\nExample Message One")
}

// Example Function with return type
fun exampleFunctionTwo(): String{
    val message = "\nExample Message Two"
    return message
}

// Example Function with return type and parameter
fun exampleFunctionThree(number: String): String{
    val message = "\nExample Message $number"
    return message
}

// Example Function with Named arguments
fun exampleFunctionFour(number: String, Text: String): String{
    val message = "\nExample $Text $number"
    return message
}

// Example for Default argument Function
fun exampleFunctionFive(number: String = "Five"): String{
    val message = "\nExample Message $number"
    return message
}