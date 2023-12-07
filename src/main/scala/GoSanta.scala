import scala.io.Source

import DayOne.sumCalibrationValues

@main def main(): Unit =
  val filePath = Source.getClass.getResource("/day-one-part-one.txt").getPath
  val sum = sumCalibrationValues(filePath)
  println(s"Day one part 1: $sum")
