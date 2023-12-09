import scala.io.Source

import DayOne.{sumCalibrationValues, decryptCalibration}

@main def main(): Unit =
  var source = Source.fromResource("day-one.txt")

  val sum = sumCalibrationValues(source)
  println(s"Day 1 part 1: $sum")

  source = Source.fromResource("day-one.txt")
  val newSum = decryptCalibration(source)
  println(s"Day 1 part 2: $newSum")
