package Strings

/**
 * Created by pradeepsanchana on 03/07/18.
 */
object WordDiffString {
  def main(args: Array[String]) {
    var a = "It is likely that we will have to have interactive sessions for these advanced"
    var b = "is that we will have to have sessions these"
    var x = a.split(" ")
    var y = b.split(" ")
    x.diff(y).foreach(print)
  }

}
