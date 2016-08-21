object LearningScala3 {
  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
  def squareIt(x: Int) : Int = {
  	x * x
  }                                               //> squareIt: (x: Int)Int
  
  def cubeIt(x: Int): Int = {x * x * x}           //> cubeIt: (x: Int)Int
  def doubleIt(x: Int): Int = {x * 2}             //> doubleIt: (x: Int)Int
  def tripleIt(x: Int): Int = {x * 3}             //> tripleIt: (x: Int)Int

	  
	
  println(squareIt(3))                            //> 9
  
  println(cubeIt(3))                              //> 27
  
  println(doubleIt(10))                           //> 20
  
  println(tripleIt(100))                          //> 300
 
  
  // Functions can take other functions as parameters
  
  def transformInt(x: Int, f: Int => Int) : Int = {
  	f(x)
  }                                               //> transformInt: (x: Int, f: Int => Int)Int
    
  val result = transformInt(2, cubeIt)            //> result  : Int = 8
  println (result)                                //> 8
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  transformInt(3, x => x * x )                    //> res0: Int = 9
  
  transformInt(10, x => x / 2)                    //> res1: Int = 5
  
  transformInt(2, x => {val y = x * 2; y * y})    //> res2: Int = 16
  
  // This is really important!
  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  
  val str: String = "srikanth bellary"            //> str  : String = srikanth bellary
  def strUpper1: String = str.toUpperCase         //> strUpper1: => String
  println(strUpper1)                              //> SRIKANTH BELLARY
  
  def strUpper(x: String, f: String => Int) = { f(x)}
                                                  //> strUpper: (x: String, f: String => Int)Int
  strUpper("1986", x => x.toInt)                  //> res3: Int = 1986
    
  
  
}