package code.snippet

import net.liftweb._
import common.{Loggable, Full}
import util._
import Helpers._
import http.{S, SHtml}
import http.js._
import code.lib.{SessionData, SunglassUser}
import code.model.SJUser

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 6:33 PM
 * To change this template use File | Settings | File Templates.
 */
class Login extends Loggable {

  var email = ""
  var password =""

  def process() = {
    if(SunglassUser.authenticateUser(email, password)) {
      println("Login Success")
      val user = SJUser.findOrCreate(email, password)
      // set current user
      SessionData.currentUser.set(Full(user))
      JsCmds.Run("$(\"#loginBox\").fadeOut(400, function(){$(\"#app\").fadeIn(400)});filterCards();")
    } else {
      println("Login Failed")
      JsCmds.Run("$(\"#loginBoxError\").fadeIn(400)")
    }
  }

  def render = {
    "@email" #> SHtml.text(email, email = _) &
    "@password" #> (SHtml.password(password, password = _) ++
    SHtml.hidden(process))
  }

  def showLogin = {
    if(SessionData.isLoggedIn()) {
      "#loginBox [style+]" #> "display:none"
    } else {
      "#loginBox [style+]" #> "display:block"
    }
  }

  def showApp = {
    if(!SessionData.isLoggedIn()) {
      "#app [style+]" #> "display:none"
    } else {
      "#app [style+]" #> "display:block"
    }
  }

//  def ifLoggedIn = {
//    val action = S.attr("action", _.toString).map(_ == "show") openOr false
//    val loggedIn = SessionData.isLoggedIn()
//    println(action + " " + loggedIn)
//
//    val res =
//    if(action && loggedIn || !action && !loggedIn) {
//      println("Yes")
//      "div [style+]" #> "display:block"
//    } else {
//      println("No")
//      "div [style+]" #> "display:none"
//    }
//    res
//  }
}
