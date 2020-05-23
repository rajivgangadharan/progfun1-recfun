package mathfun

import org.junit._

class MathOperSuite {
import MathOper._

 @Test def `adding_integers_in_range-12to19` : Unit = {
   assert(sumInt(12,19) == 124)
 }

  @Test def `adding_integers_in_range-12to19 (using anonymous functions)` : Unit = {
    assert(sum (x => x) (12, 19) == 124)
  }

  @Test def `adding_sub_of_cubes_between_3and4` :Unit = {
    assert(sum (cube) (3,4) == 91)
  }

/*  @Test def `adding_sub_of_cubes_between_3and4 using anonymous functions` :Unit = {
    assert(sum((x => x * x * x), 3, 4) == 91)
  }*/

  @Test def `factorial of 1 is 1`  : Unit = {
    assert(fact(1) == 1)
  }

  @Test def `factorial of 0 is 1` : Unit = {
  assert(fact(0) == 1)
  }

  @Test def `factorial of 5 is 120`: Unit = {
    assert(fact(5) == 120)
  }

  @Test def `sum of factorials between 4 to 6 is 864`:Unit =
    assert(sumFact(4,6) == 864)

/*  @Test def `sum of factorials between 4 to 6 is 864 - functional version`:Unit =
    assert(sum(fact, 4,6) == 864)*/

  @Test def `product of numbers from 3 to 7 is 2520`: Unit =
    assert(product(Int => Int) (3, 7) == 2520)

  // Factorial using product function
  @Test def `factorial using product function - factorial of 5 gives 120`: Unit =
    assert(factorial(5) == 120)

  @Test def `product of numbers using mapReduce function - product of 1 to 5 gives 120`: Unit = {
    assert(product(x => x * x)(1, 5) == 120)
  }

  @Test def `product of numbers using mapReduce function - product of 1 to 3 gives 6`: Unit = {
    assert(product(x => x * x)(1, 3) == 6)
  }

/*  @Test def `sum of numbers using mapReduce function - sum of 1 to 5 gives 12`: Unit = {
    assert(sum(x => x + x)(1, 5) == 15)
  }*/



/*  @Test def `sum of numbers using mapReduce function - sum of 1 to 5 gives 5`: Unit = {
    assert(sum(x => x + x)(1, 3) == 5)
  }*/

  @Test def `square root of 9 is 3`: Unit = {
    assert(sqrt(9) == 3)
  }

  @Test def `square root of 4 is 2`: Unit = {
    assert(sqrt(4) == 2)
  }
}
