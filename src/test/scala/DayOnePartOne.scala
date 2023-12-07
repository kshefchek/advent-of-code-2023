import DayOne.{getCalibrationValue, sumCalibrationValues}

class DayOnePartOne extends munit.FunSuite {
  test("Test getCalibrationValue") {
    var code = getCalibrationValue("1abc2")
    assertEquals(code, 12)

    code = getCalibrationValue("pqr3stu8vwx")
    assertEquals(code, 38)

    code = getCalibrationValue("a1b2c3d4e5f")
    assertEquals(code, 15)

    code = getCalibrationValue("treb7uchet")
    assertEquals(code, 77)
  }

  test("Test sumCalibrationValues") {
    val filePath = getClass.getResource("day-one-part-one.txt").getPath
    val sum = sumCalibrationValues(filePath)

    assertEquals(sum, 142)
  }
}
