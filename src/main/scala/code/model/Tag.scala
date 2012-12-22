package code.model

import net.liftweb._
import mapper._

/**
 * Created with IntelliJ IDEA.
 * User: dasher
 * Date: 12/22/12
 * Time: 5:33 PM
 * To change this template use File | Settings | File Templates.
 */
class Tag extends LongKeyedMapper[Tag] with ManyToMany with IdPK  {

  def getSingleton = Tag

  object text extends MappedString(this, 100)
  object taggedPosts extends MappedManyToMany(TagAssigned, TagAssigned.tag, TagAssigned.post, Post)
}

object Tag extends Tag with LongKeyedMetaMapper[Tag] {

}

class TagAssigned extends Mapper[TagAssigned] {
  def getSingleton = TagAssigned
  object tag extends MappedLongForeignKey(this, Tag)
  object post extends MappedLongForeignKey(this, Post)
}

object TagAssigned extends TagAssigned with MetaMapper[TagAssigned] {

}
