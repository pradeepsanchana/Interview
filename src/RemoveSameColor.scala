import scala.collection.mutable.ListBuffer

/**
 * Created by pradeepsanchana on 21/06/18.
 */
object RemoveSameColor {
  def main(args: Array[String]) = {
    var a = ListBuffer[Char]('R', 'G', 'B', 'B', 'G', 'R', 'Y')
    removeColors(a).foreach(print)
    println()
    var b = ListBuffer[Char]('R', 'G', 'G','B', 'B', 'G','G', 'R', 'Y')
    removeColors(b).foreach(print)

  }

  def removeColors(a: ListBuffer[Char]): ListBuffer[Char] = {
    reRemove(a, 0, a.length - 1)
  }

  def reRemove(a: ListBuffer[Char], s: Int, e: Int): ListBuffer[Char] = {
    if (nosameColors(a)) {
      return a
    }
    var l = a.length
    var i =0
    for (i <- 0 to l - 2) {
      if (a(i) == a(i + 1)) {
        a.remove(i)
        a.remove(i)
        return reRemove(a, 0, a.length - 1)
      }

    }
    return ListBuffer()
    //reRemove(a, 0, a.length - 1)
  }

  def nosameColors(a: ListBuffer[Char]): Boolean = {
    for (i <- 0 to a.length - 2) {
      if (a(i) == a(i + 1)) {
        return false
      }
    }
    true
  }
}
