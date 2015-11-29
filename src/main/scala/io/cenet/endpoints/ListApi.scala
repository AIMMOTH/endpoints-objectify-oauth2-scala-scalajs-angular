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
import io.cenet.shared.validator.SplitValidator
import io.cenet.datastore.Objectify
import io.cenet.endpoints.result.IdResult
import io.cenet.datastore.entity.ListEntity

@Api(version = "v1", name = "list", authenticators = Array(classOf[ScalaAuthenticator]))
class ListApi {
  
  /**
   * Get by id.
   */
  @ApiMethod(httpMethod = "get")
  def get(@Named("id") id : JLong) =
    Objectify.load.key(Key.create(classOf[ListEntity], id)).now
  
  /**
   * Creates new entity and return it's new id.
   */
  @ApiMethod(httpMethod = "post")
  def post(@Named("csv") csv : String) =
    Objectify.save.entity(new ListEntity(SplitValidator(csv).toList)).now match {
      case entity => IdResult(entity.getId)
    }
  
  /**
   * Updates the entity with an idempotent work (in case other processes
   * uses the entity).
   */
  @ApiMethod(httpMethod = "put", path = "{id}")
  def put(@Named("id") id : JLong, @Named("csv") csv : String) : Unit =
    // Make PUT (update) idempotent
    Objectify.transaction(new VoidWork {
      override def vrun =
        Objectify.load.key(Key.create(classOf[ListEntity], id)).now match {
          case existing : ListEntity => 
            existing.list = SplitValidator(csv).toList
            Objectify.save.entity(existing).now
          }
    })
  
    /**
     * Deletes the entity with an idempotent work (in case other processes
     * uses the entity).
     */
  @ApiMethod(httpMethod = "delete", path = "{id}")
  def delete(user : ApiUser, @Named("id") id : JLong) : Unit = 
    // Make DELETE (update) idempotent
    Objectify.transaction(new VoidWork {
      override def vrun =
        Objectify.delete.key(Key.create(classOf[ListEntity], id)).now
    })
}