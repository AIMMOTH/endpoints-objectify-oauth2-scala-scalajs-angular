package io.cenet.endpoints

import java.lang.{Long => JLong}
import javax.inject.Named
import scala.collection.JavaConversions._
import com.google.api.server.spi.config.Api
import com.google.api.server.spi.config.ApiMethod
import com.googlecode.objectify.Key
import com.google.appengine.api.users.{User => ApiUser}
import com.googlecode.objectify.VoidWork
import java.util.Arrays
import io.cenet.datastore.Objectify
import io.cenet.datastore.entity.JavaEntity

@Api(version = "v1", name = "named", authenticators = Array(classOf[ScalaAuthenticator]))
class NamedApi {
  
  /**
   * Get by name.
   */
  @ApiMethod(httpMethod = "get", path = "{name}")
  def get(@Named("name") name : String) =
    Objectify.load.key(Key.create(classOf[JavaEntity], name)).now()
  
  /**
   * Creates new entity with parameter.
   */
  @ApiMethod(httpMethod = "post")
  def post(@Named("name") name : String) : Unit =
    Objectify.save.entity(new JavaEntity(name))
  
  /**
   * Updates the entity with an idempotent work (in case other processes
   * uses the entity).
   */
  @ApiMethod(httpMethod = "put", path = "{name}")
  def put(@Named("name") name : String) : Unit =
    // Make PUT (update) idempotent
    Objectify.transaction(new VoidWork {
      override def vrun =
        Objectify.load.key(Key.create(classOf[JavaEntity], name)).now match {
          case existing : JavaEntity => 
            existing.lastModified = System.currentTimeMillis()
            Objectify.save.entity(existing).now
          }
    })
  
    /**
     * Deletes the entity with an idempotent work (in case other processes
     * uses the entity).
     */
  @ApiMethod(httpMethod = "delete", path = "{name}")
  def delete(user : ApiUser, @Named("name") name : String) : Unit = 
    // Make DELETE (update) idempotent
    Objectify.transaction(new VoidWork {
      override def vrun =
        Objectify.delete.key(Key.create(classOf[JavaEntity], name)).now
    })
}