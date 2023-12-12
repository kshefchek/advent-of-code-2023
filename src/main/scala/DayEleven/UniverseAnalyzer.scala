package DayEleven

import scala.collection.mutable
import scala.io.BufferedSource

def sumShortestPaths(source: BufferedSource, expansionMultiplier: Int = 2): Int =
  val universe = source.getLines
    .to(LazyList)
    .map {
      _.split("")
    }

  val universeRowsExpanded = universe.flatMap { line =>
    if (line.forall(_ == ".")) List.fill(expansionMultiplier)(line)
    else List(line)
  }

  // TODO DRY this up
  val universeExpanded = universeRowsExpanded.transpose.flatMap { line =>
    if (line.forall(_ == ".")) List.fill(expansionMultiplier)(line)
    else List(line)
  }.transpose

  // Create a hashmap of coordinates and get manhattan distance: | x1 − x2 | + | y1 − y2
  val coordinates = new mutable.HashMap[String, (Int, Int)]

  universeExpanded.zipWithIndex
    .foreach { case (rowValue, rowIndex) =>
      rowValue.zipWithIndex.foreach { case (colValue, colIndex) =>
        colValue match {
          case "#" =>
            val key = rowIndex.toString + "_" + colIndex.toString
            coordinates.put(key, (rowIndex, colIndex))
          case _ => Nil
        }
      }
    }

  val galaxies: List[(String, String)] = coordinates.keys.toList.combinations(2).toList.map {
    case List(galaxy1, galaxy2) => (galaxy1, galaxy2)
  }

  def getManhattan(aCoord: (Int, Int), bCoord: (Int, Int)): Int =
    // | x1 − x2 | + | y1 − y2 |
    ((aCoord(0) - bCoord(0)).abs  + (aCoord(1) - bCoord(1)).abs)

  galaxies.map{ case (a, b) => (coordinates.getOrElse(a, (0,0)), coordinates.getOrElse(b, (0,0))) }
    .map(getManhattan)
    .sum
