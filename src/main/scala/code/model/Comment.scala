package code.model

import net.liftweb.mapper._

/**
 * Created with IntelliJ IDEA.
 * User: comet
 * Date: 22/12/12
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
class Comment extends LongKeyedMapper[Comment] with IdPK {
  def getSingleton = Comment

  // Columns
  object text extends MappedString(this, 255)
  object author extends MappedLongForeignKey(this, SJUser)
  object postId extends MappedLongForeignKey(this, Post)
  object createdAt extends MappedDateTime(this)
}
