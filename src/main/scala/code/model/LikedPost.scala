package code.model

import net.liftweb._
import mapper._

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 5:36 PM
 * To change this template use File | Settings | File Templates.
 */
class LikedPost extends Mapper[LikedPost] {

  object post extends MappedLongForeignKey(this, Post)
  object user extends MappedLongForeignKey(this, SJUser)

  def getSingleton  = LikedPost
}

object LikedPost extends LikedPost with MetaMapper[LikedPost] {

}
