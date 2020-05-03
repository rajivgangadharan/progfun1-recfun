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
    var l:List[Char] = ":-)".toList
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
    if (lt.nonEmpty) {
      val head :: tail = lt
      if (isOpenBracket(head)) es.push(head)
      if (isCloseBracket(head)) {
        if (es.isEmpty) es.push(head)
        if (isOpenBracket(es.top)) es.pop
      }
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
    def count(value: Int, coins: List[Int]):Int = {
      if (value == 0) return 1 // if the value of zero then there is exactly 1 way
      if (value < 0 || coins.isEmpty) return 0
      val head::tail = coins
      count(value - head, coins) + count(value, tail)
    }

  def countChange(money: Int, coins: List[Int]): Int = count(money,coins)

}
