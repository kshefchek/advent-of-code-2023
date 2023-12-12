import DayEleven.sumShortestPaths

import scala.io.Source

class DayEleven extends munit.FunSuite {
  test("Test sumShortestPaths") {
    val source = Source.fromResource("day-eleven-part-one.txt")
    val sum = sumShortestPaths(source)

    assertEquals(sum, 374)
  }
}
