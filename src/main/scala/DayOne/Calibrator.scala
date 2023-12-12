package DayOne

import scala.collection.immutable.HashMap
import scala.io.BufferedSource

// https://adventofcode.com/2023/day/1

/** Day 1 part 1
  */
def getCalibrationValue(encryptedCode: String): Int =
  val digits = encryptedCode.toList
    .filter(char => char.isDigit)

  digits.length match {
    case 0 => 0
    case _ => s"${digits.head}${digits.last}".toInt
  }

def sumCalibrationValues(source: BufferedSource): Int =
  source.getLines.to(LazyList).map(getCalibrationValue).sum

/** Day 1 part 2
  */
def convertWordToIntChar(encryptedCode: String): String =
  val numbers = List("one", "two", "three", "four", "five", "six", "seven", "eight", "nine")
  val myMap: HashMap[String, String] =
    numbers.zipWithIndex.map { case (number, index) => number -> (index + 1).toString }.to(HashMap)

  val numberRegex = ("(?=(" + numbers.mkString("|") + "|\\d))").r

  numberRegex
    .findAllIn(encryptedCode)
    .matchData
    .flatMap({ patternMatch =>
      List(
        myMap.getOrElse(patternMatch.group(0), patternMatch.group(0)),
        myMap.getOrElse(patternMatch.group(1), patternMatch.group(1))
      )
    })
    .mkString("")

def decryptCalibration(source: BufferedSource): Int =
  source.getLines.to(LazyList).map(convertWordToIntChar).map(getCalibrationValue).sum
