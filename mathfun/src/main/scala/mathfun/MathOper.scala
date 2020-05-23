package mathfun

object MathOper {

/*  def sum(f: Int => Int, a: Int, b: Int ): Int =
    if (a > b) 0 else f(a) + sum(f, a + 1, b)*/

  /*def product(f:Int => Int)(a: Int, b: Int): Int =
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
*/
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  def product(f: Int => Int)(a: Int, b: Int): Int =
    mapReduce(f, (x, y) => x * y, zero = 1)(a, b)

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    mapReduce(f, (x, y) => x + y, zero = 0)(a, b)
  }





/*  def sum(f: Int => Int, a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, acc = 0)
  }*/

/*  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }*/



  def factorial(x: Int) = {
    if (x == 0 || x == 1) 1 else product(x => x)(1, x)
  }


  def cube (x: Int): Int = x * x * x
  def fact(n: Int):Int = if (n == 0) 1 else if (n == 1) 1 else n * fact(n -1)
  def id(n: Int): Int = if (n == 0) 0 else n + id(n - 1)

  def sumInt(a: Int, b: Int): Int =
    if (a > b) 0 else a + sumInt(a + 1, b)
  def sumCubes(x:Int, y:Int):Int =
    if (x > y) 0 else cube(x) + sumCubes(x + 1, y)
  def sumFact(a: Int, b: Int): Int =
    if (a > b) 0 else fact(a) + sumFact(a + 1, b)

  final val tolerance:Double = 0.0001
  def isCloseEnough(x: Double, y:Double):Boolean = abs((x - y) / x) / x < tolerance
  def fixedPoint(f: Double  => Double)(guess :Int): Double = {
    def iterate(guess: Double): Double = {
      val next: Double = f(guess)
      if (isCloseEnough(guess, next)) next else iterate(next)
    }
    iterate(guess)
  }





}
