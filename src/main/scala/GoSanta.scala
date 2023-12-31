import scala.io.Source

import DayOne.{sumCalibrationValues, decryptCalibration}
import DayNine.{sumHistoryValues, sumHistoryValuesBackwards}
import DayEleven.{sumShortestPaths}


@main def main(): Unit =
  var source = Source.fromResource("day-one.txt")

  val sum = sumCalibrationValues(source)
  println(s"Day 1 part 1: $sum")

  source = Source.fromResource("day-one.txt")
  val newSum = decryptCalibration(source)
  println(s"Day 1 part 2: $newSum")

  source = Source.fromResource("day-nine.txt")
  val historySum = sumHistoryValues(source)
  println(s"Day 9 part 1: $historySum")

  source = Source.fromResource("day-nine.txt")
  val historySumBackwards = sumHistoryValuesBackwards(source)
  println(s"Day 9 part 2: $historySumBackwards")

  source = Source.fromResource("day-eleven.txt")
  val sumGalaxyPaths = sumShortestPaths(source)
  println(s"Day 11 part 1: $sumGalaxyPaths")

  source = Source.fromResource("day-eleven.txt")
  val sumGalaxyPathsTimesAMillion = sumShortestPaths(source, 1000000)
  println(s"Day 11 part 2: $sumGalaxyPathsTimesAMillion")
