object LearningScala1 {
  // VALUES are immutable constants. You can't change them once defined.
  val hello: String = "Namasthe!"                 //> hello  : String = Namasthe!
  println(hello)                                  //> Namasthe!
  
  // Notice how Scala defines things backwards from other languages - you declare the
  // name, then the type.
  
  // VARIABLES are mutable
  var helloThere: String = hello                  //> helloThere  : String = Namasthe!
  helloThere = hello + " There!"
  println(helloThere)                             //> Namasthe! There!
  
  
  // One key objective of functional programming is to use immutable objects as often as possible.
  // Try to use operations that transform immutable objects into a new immutable object.
  // For example, we could have done the same thing like this:
  val immutableHelloThere = hello + "There!"      //> immutableHelloThere  : String = Namasthe!There!
  println(immutableHelloThere)                    //> Namasthe!There!
  
  // Some other types
  val numberTwo : Int = 2                         //> numberTwo  : Int = 2
  val truth : Boolean = true                      //> truth  : Boolean = true
  val letterA : Char = 'a'                        //> letterA  : Char = a
  val pi : Double = 3.14159265                    //> pi  : Double = 3.14159265
  val piSinglePrecision : Float = 3.14159265f     //> piSinglePrecision  : Float = 3.1415927
  val bigNumber : Long = 1234567890l              //> bigNumber  : Long = 1234567890
  val smallNumber : Byte = 127                    //> smallNumber  : Byte = 127
  
  // String printing tricks
  // Concatenating stuff with +:
  println("Here is a mess: " + numberTwo + truth + letterA + pi + bigNumber)
                                                  //> Here is a mess: 2truea3.141592651234567890
  
  // printf style:
  println(f"Pi is about $piSinglePrecision%.4f")  //> Pi is about 3.1416
  println(f"Zero padding on the left: $numberTwo%06d")
                                                  //> Zero padding on the left: 000002
                                                  
  // Substituting in variables:
  println(s"I can use the s prefix to use variables like $numberTwo $truth $letterA")
                                                  //> I can use the s prefix to use variables like 2 true a
  // Substituting expressions (with curly brackets):
  println(s"The s prefix isn't limited to variables; I can include any expression. Like ${2+3}")
                                                  //> The s prefix isn't limited to variables; I can include any expression. Like
                                                  //|  5
                                                 
  // Using regular expressions:
  val theUltimateAnswer: String = "To life, the universe, and everything is 42."
                                                  //> theUltimateAnswer  : String = To life, the universe, and everything is 42.
                                                  //| 
  val pattern = """.* ([\d]+).*""".r              //> pattern  : scala.util.matching.Regex = .* ([\d]+).*
  val pattern(answerString) = theUltimateAnswer   //> answerString  : String = 42
  val answer = answerString.toInt                 //> answer  : Int = 42
  println(answer)                                 //> 42
  
  // Dealing with booleans
  val isGreater = 1 > 2                           //> isGreater  : Boolean = false
  val isLesser = 1 < 2                            //> isLesser  : Boolean = true
  val impossible = isGreater & isLesser           //> impossible  : Boolean = false
  val anotherWay = isGreater && isLesser          //> anotherWay  : Boolean = false
  
  val picard: String = "Picard"                   //> picard  : String = Picard
  val bestCaptain: String = "Picard"              //> bestCaptain  : String = Picard
  val isBest: Boolean = picard == bestCaptain     //> isBest  : Boolean = true
  
  // EXERCISE
  // Write some code that takes the value of pi, doubles it, and then prints it within a string with
  // three decimal places of precision to the right.
  // Just write your code below here; any time you save the file it will automatically display the results!
  
 
  val new_pi = 3.14159265                         //> new_pi  : Double = 3.14159265
  println(new_pi)                                 //> 3.14159265
  
  val mod_pi = 2 * new_pi                         //> mod_pi  : Double = 6.2831853
  println(mod_pi)                                 //> 6.2831853
  println(f"new_pi with three decimal places is $new_pi%.3f")
                                                  //> new_pi with three decimal places is 3.142
  val pi_type : String = "new_pi with four decimal places is "
                                                  //> pi_type  : String = "new_pi with four decimal places is "
  println( pi_type + f"$new_pi%.4f")              //> new_pi with four decimal places is 3.1416
                                          
  
  
  
  
}