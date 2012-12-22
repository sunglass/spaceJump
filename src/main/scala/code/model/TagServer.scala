package code.model

import net.liftweb._
import actor.LiftActor
import http._
import util._
import Helpers._
import code.model._

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 9:42 PM
 * To change this template use File | Settings | File Templates.
 */
object TagServer extends LiftActor with ListenerManager {

  private var tags = Vector.empty[Tag]

  def createUpdate = tags

  override def lowPriority = {
    case t:Tag => tags :+= t; updateListeners()
  }
}
