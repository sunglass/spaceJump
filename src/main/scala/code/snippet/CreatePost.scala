package code.snippet

import code.model._
import net.liftweb._
import util._
import Helpers._
import http.js._
import http.SHtml
import code.lib.SessionData

/**
 * Created with IntelliJ IDEA.
 * User: comet
 * Date: 22/12/12
 * Time: 7:51 PM
 * To change this template use File | Settings | File Templates.
 */
class CreatePost {
  // Post elements here

  var link = ""
  var desc = ""
  var tagTexts = ""

  def findTagForText(tagText:String) = {
    import mapper._
    Tag.find(By(Tag.text, tagText))
  }

  def process2() = {
    println("Process Called!! CreatePost")
    println(link + ", " + desc + ", " + tagTexts)
    (for {
      usr <- SessionData.currentUser.is
    } yield {
      val tags = tagTexts.split(",").flatMap(findTagForText(_))
      val post = Post.create.link(link).text(desc).author(usr).createdAt(now).saveMe()
      post.assignedTags ++= tags
      post.save
      println(tags)
      println(usr)
      println(post)
      JsCmds.Alert("Post saved")
    }) openOr{println("noUser");JsCmds.Alert("Post not saved!")}
  }

  def render = {
    println("Render Called!! CreatePost")

    "#linkBox" #> SHtml.text("", link = _) &
    "#descriptionBox" #> SHtml.text("", desc = _) &
    "#tagBox" #> (SHtml.text("", tagTexts = _) ++
      SHtml.hidden(process2))
  }
}
