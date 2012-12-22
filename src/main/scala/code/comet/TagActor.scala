package code.comet

import net.liftweb._
import http._
import js.JsCmds.{Run, Script}
import util._
import Helpers._
import code.model._
/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */
class TagActor extends CometActor with CometListener {
  private var tags = Vector.empty[Tag]

  def registerWith = TagServer

  override def lowPriority = {
    case tagList: Vector[Tag] => tags = tagList; reRender()
  }

  def render = {
    val res = tags.map(_.text.is).mkString("[\"", "\",\"", "\"]")
    Script(Run("availableTags = " + res + ";"))
  }
}
