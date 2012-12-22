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
  object text extends MappedText(this)
}

object Post extends Post with LongKeyedMetaMapper[Post] {}
