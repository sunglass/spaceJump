package code.lib

import dispatch._
import net.liftweb.util.Helpers._

/**
 * Created with IntelliJ IDEA.
 * User: z33m
 * Date: 12/22/12
 * Time: 6:11 PM
 * To change this template use File | Settings | File Templates.
 */
object SunglassUser {
  def authenticateUser(email:String, password:String) = {
    val req = url("https://sunglass.io/login").POST
    req.addParameter("email", email).addParameter("password", password)
    tryo{Http(req OK as.String)()}.isDefined
  }
}
