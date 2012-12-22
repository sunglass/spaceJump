package code.snippet

import net.liftweb._
import http.js.JE.Str
import http.js.JsCmds.{Run, Script}
import json._
import code.model.Tag

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
class InjectJs {

  def render = {
    println("Injecting shit into page")
    val tags = Tag.findAll().map(_.text.is).mkString("[\"", "\",\"", "\"]")
    println(Tag.findAll().size)
    println(tags)
    val res = Script(Run("var availableTags = " + tags + ";"))
    <head>{res}</head>
  }
}
