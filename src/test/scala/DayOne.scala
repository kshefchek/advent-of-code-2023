import DayOne.{convertWordToIntChar, decryptCalibration, getCalibrationValue, sumCalibrationValues}

import scala.io.Source

class DayOne extends munit.FunSuite {

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
    val source = Source.fromResource("day-one-part-one.txt")
    val sum = sumCalibrationValues(source)

    assertEquals(sum, 142)
  }

  test("Test convertWordToIntChar") {
    var decrypterCode = convertWordToIntChar("2eightwo3")
    assertEquals(decrypterCode, "2823")

    decrypterCode = convertWordToIntChar("eightwoone")
    assertEquals(decrypterCode, "821")

    decrypterCode = convertWordToIntChar("2djldhkkcn55three2threefourflnxnbzh19")
    assertEquals(decrypterCode, "255323419")
  }

  test("Test decryptCalibration") {
    val source = Source.fromResource("day-one-part-two.txt")
    val sum = decryptCalibration(source)

    assertEquals(sum, 281)
  }

}
