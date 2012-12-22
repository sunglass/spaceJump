package code.snippet

import net.liftweb._
import common.{Loggable, Full}
import util._
import Helpers._
import http.{S, SHtml}
import http.js._
import code.model.Post
import net.liftweb.util.ClearClearable

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 7:39 PM
 * To change this template use File | Settings | File Templates.
 */
class Content {
  def contentList = {
    ".cardItemBox *" #> Post.findAll().map { post =>
      ".cardItemAuthor *" #> post.author &
      ".cardItemLink [href]" #> post.link &
      ".cardItemDesc *" #> post.text
    } & ClearClearable
  }
}
