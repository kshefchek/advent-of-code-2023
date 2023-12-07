package DayOne

import scala.io.Source

// https://adventofcode.com/2023/day/1
def getCalibrationValue(encryptedCode: String): Int =
  val digits = encryptedCode.toList
    .filter(char => char.isDigit)

  digits.length match {
    case 0 => 0
    case _ => s"${digits.head}${digits.last}".toInt
  }

def sumCalibrationValues(filePath: String): Int =
  val source = Source.fromFile(filePath)
  source.getLines.to(LazyList).map(getCalibrationValue).sum
