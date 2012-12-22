package code.lib

import net.liftweb.http.SessionVar
import net.liftweb.common._
import code.model.SJUser


/**
 * Created with IntelliJ IDEA.
 * User: z33m
 * Date: 12/22/12
 * Time: 6:02 PM
 * To change this template use File | Settings | File Templates.
 */

object SessionData {
  object currentUser extends SessionVar[Box[SJUser]](Empty)

  def isLoggedIn() = currentUser.get.isDefined
}
