package code.model

import net.liftweb.mapper._

/**
 * Created with IntelliJ IDEA.
 * User: z33m
 * Date: 12/22/12
 * Time: 5:21 PM
 * To change this template use File | Settings | File Templates.
 */
class Post extends LongKeyedMapper[Post] with IdPK {
  def getSingleton = Post

  object text extends MappedText(this)
  object link extends MappedString(this, 2000)
  object author extends MappedLongForeignKey(this, SJUser)
  object createdAt extends MappedDateTime(this)
  object commentCount extends MappedLong(this)
  object tagCount extends MappedLong(this)
  object likeCount extends MappedLong(this)
}

object Post extends Post with LongKeyedMetaMapper[Post] {}
