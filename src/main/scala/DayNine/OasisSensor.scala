package DayNine

import scala.io.BufferedSource

def predictNextValue(history: List[Int]): Int =

  def getNextSequence(history: List[Int]): List[Int] =
    val subtrahend = history.tail
    val nextSequence = history.zip(subtrahend)
    nextSequence.map { case (x, y) => y - x }

  // TODO solve this more functionally without using var
  var accumulatorList: List[List[Int]] = List(history)

  while accumulatorList.last.sum != 0
  do accumulatorList = accumulatorList :+ getNextSequence(accumulatorList.last)

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
