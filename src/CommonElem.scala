
/**
 * Created by pradeepsanchana on 12/04/18.
 */
object CommonElem {
  def commonEle(a: Array[Int], b: Array[Int]): Int = {
    var c = 0

    //breakable {
      var i = 0
      var j = 0
      while (i < a.length - 1 && j < b.length-1) {
          if (a(i) == b(j)) {
            i += 1
            j += 1
            c += 1
          }
          else if (a(i) < b(j)) {
            i += 1
          } else {
            j += 1
          }

      //    if (h - 1)
      //      break
        //}
      }
      c

  }
    def main(args: Array[String]) {
      var a = Array(1, 3, 4, 5, 6, 7)
      var b = Array(1, 2, 3, 4, 8, 9, 10, 11)
      var c = commonEle(a, b)
      println(c)
    }
}
