package code.model

import net.liftweb.mapper.{MappedTime, MappedLong, MappedString, LongKeyedMapper}

/**
 * Created with IntelliJ IDEA.
 * User: comet
 * Date: 22/12/12
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */
class SJComment extends LongKeyedMapper[SJComment] with IdPK{
  def getSingleton = SJComment

  // Columns
  object text extends MappedString(this, 255)
  object author extends MappedString(this, 255)
  object timestamp extends MappedTime(this)
  object postId extends MappedLong(this)
}
