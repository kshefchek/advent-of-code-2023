package DayNine

import scala.annotation.tailrec
import scala.io.BufferedSource

def predictNextValue(history: List[Int]): Int =

  def getNextSequence(history: List[Int]): List[Int] =
    val subtrahend = history.tail
    val nextSequence = history.zip(subtrahend)
    nextSequence.map { case (x, y) => y - x }

  @tailrec
  def getHistory(historyList: List[List[Int]]): List[List[Int]] =
    if historyList.last.sum == 0 then
      historyList
    else
      val newList = historyList :+ getNextSequence(historyList.last)
      getHistory(newList)

  val accumulatorList: List[List[Int]] = getHistory(List(history))

  accumulatorList.map(_.last).sum

def sumHistoryValues(source: BufferedSource): Int =
  source.getLines
    .to(LazyList)
    .map { _.split(" ").map(_.toInt).toList }
    .map(predictNextValue)
    .sum

def sumHistoryValuesBackwards(source: BufferedSource): Int =
  source.getLines
    .to(LazyList)
    .map { _.split(" ").map(_.toInt).toList.reverse }
    .map(predictNextValue)
    .sum
