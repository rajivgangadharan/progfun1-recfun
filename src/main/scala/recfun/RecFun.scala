package recfun

import scala.collection.mutable.ListBuffer
import scala.collection.immutable.List
import scala.collection.mutable

class ExpressionStack extends mutable.Stack[Char]

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(s"${pascal(col, row)} ")
      println()
    }
    //var l: List[Char] = "())(".toList
    //println(s"March brackets ${balance(l)}")
    var l:List[Char] = "())".toList
    println(s"March brackets ${balance(l)}")
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1 else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  private def isOpenBracket(c: Char):Boolean = if (c == '(') true else false
  private def isCloseBracket(c: Char):Boolean = if(c ==')') true else false
  def matchExpression(es: ExpressionStack, lt: List[Char]): Boolean = {
    if (!lt.isEmpty) {
      val head :: tail = lt
      if (isOpenBracket(head)) es.push(head)
      if (isCloseBracket(head) && es.nonEmpty && isOpenBracket(es.top))
        if (es.nonEmpty) es.pop
      matchExpression(es, tail)
    }
    if (es.isEmpty) true else false
  }

  def balance(chars: List[Char]): Boolean = {
    var es: ExpressionStack = new ExpressionStack
    if (matchExpression(es,chars)) true else false
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = 1
}
