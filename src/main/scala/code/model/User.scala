package code
package model

import net.liftweb.mapper._
import net.liftweb.util._
import net.liftweb.common._

/**
 * Space jump user
 */
class SJUser extends LongKeyedMapper[SJUser] with IdPK {
  def getSingleton = SJUser // what's the "meta" server

  //object id extends MappedLongIndex(this)
  object username extends MappedString(this, 255)
  object email extends MappedEmail(this, 255)
}

object SJUser extends SJUser with LongKeyedMetaMapper[SJUser]  {

  def findOrCreate(username:String, email:String) = {
    SJUser.find(By(SJUser.email, email)) getOrElse {
      val newUser = SJUser.create
      newUser.email(email).username(username).save()
      newUser
    }
  }

}