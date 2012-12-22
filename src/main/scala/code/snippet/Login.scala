package code.snippet

import net.liftweb._
import util._
import Helpers._
import http.SHtml
import http.js._

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
class Login {

  var email = "your sunglass email"
  var password =""

  def process() = {
    println("Processing")

    JsCmds.SetHtml("loginBoxError", xml.Text("Something happened!"))
  }

  def render = {
    println("Render called!")
    "@email" #> SHtml.text(email, email = _) &
    "@password" #> (SHtml.password(password, password = _) ++
    SHtml.hidden(process))
  }
}
