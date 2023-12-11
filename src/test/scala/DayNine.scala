import DayNine.{predictNextValue, sumHistoryValues, sumHistoryValuesBackwards}

import scala.io.Source

class DayNine extends munit.FunSuite {
  test("Test 0 3 6 9 12 15") {
    val input = List(0, 3, 6, 9, 12, 15)
    val nextVal = predictNextValue(input)

    assertEquals(nextVal, 18)
  }

  test("Test sum of values") {
    val source = Source.fromResource("day-nine-part-one.txt")
    val sum = sumHistoryValues(source)

    assertEquals(sum, 114)
  }

  test("Test backwards history") {
    val input = List(10, 13, 16, 21, 30, 45)
    val nextVal = predictNextValue(input.reverse)

    assertEquals(nextVal, 5)
  }

  test("Test backwards history sum") {
    val source = Source.fromResource("day-nine-part-one.txt")
    val sum = sumHistoryValuesBackwards(source)

    assertEquals(sum, 2)
  }
}
