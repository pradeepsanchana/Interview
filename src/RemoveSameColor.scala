import scala.collection.mutable.ListBuffer

/**
 * Created by pradeepsanchana on 21/06/18.
 */
object RemoveSameColor {
  def main(args: Array[String]) = {
    var a = ListBuffer[Char]('R', 'G', 'B', 'B', 'G', 'R', 'Y')
    print(removeColors(a))
    println()
    var b = ListBuffer[Char]('R', 'G', 'G','B', 'B', 'G','G', 'R', 'Y')
    println(removeColors(b))
    var c = ListBuffer[Char]('Y', 'R', 'G', 'G','R', 'R', 'G','G', 'R', 'Y')
    println(removeColors(c))

  }

  def removeColors(a: ListBuffer[Char]): Int = {
    reRemove(a, 0, a.length - 1)
  }

  def reRemove(a: ListBuffer[Char], s: Int, e: Int):Int = {
    if (nosameColors(a)) {
      return 0
    }
    var l = 0
    for (i <- 0 to a.length - 2) {
      if (a(i) == a(i + 1)) {
        l = i
      }
    }

    a.remove(l)
    // after removing the l emelmet l+1 element in the original wil come to l position so  remove l position again
    a.remove(l)
    return 1 + reRemove(a, 0, a.length - 1)
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
