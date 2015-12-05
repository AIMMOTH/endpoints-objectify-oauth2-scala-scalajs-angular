package io.cenet.endpoints

import java.lang.{ Long => JLong }
import scala.collection.JavaConversions._
import com.google.api.server.spi.config.Api
import com.google.api.server.spi.config.ApiMethod
import com.google.appengine.api.users.{ User => ApiUser }
import com.googlecode.objectify.Key
import com.googlecode.objectify.VoidWork
import io.cenet.datastore.Objectify
import io.cenet.datastore.entity.ListEntity
import io.cenet.endpoints.result._
import io.cenet.shared.SplitValidator
import javax.inject.Named
import io.cenet.shared.Success
import io.cenet.shared.Failure

@Api(version = "v1", name = "list", authenticators = Array(classOf[ScalaAuthenticator]))
class ListApi {
  
  @ApiMethod(httpMethod = "get")
  def getAll = new ListIdResult(Objectify.load.`type`(classOf[ListEntity]).keys().list.map(_.getId.asInstanceOf[java.lang.Long]).toList)
  
  /**
   * Get by id.
   */
  @ApiMethod(httpMethod = "get", path = "{id}")
  def get(@Named("id") id : JLong) =
    Objectify.load.key(Key.create(classOf[ListEntity], id)).now
  
  /**
   * Creates new entity and return it's new id.
   */
  @ApiMethod(httpMethod = "post")
  def post(@Named("csv") csv : String) = SplitValidator(csv) match {
    case Success((_, array)) => Objectify.save.entity(new ListEntity(array.toList)).now match {
        case entity => new IdResult(entity.getId)
      }
    case Failure(message) => throw new RuntimeException(message)
  }
    
  
  /**
   * Updates the entity with an idempotent work (in case other processes
   * uses the entity).
   */
  @ApiMethod(httpMethod = "put", path = "{id}")
  def put(@Named("id") id : JLong, @Named("csv") csv : String) : Unit =
    SplitValidator(csv) match {
      case Success((_, array)) => 
        // Make PUT (update) idempotent
        Objectify.transaction(new VoidWork {
          override def vrun = Objectify.load.key(Key.create(classOf[ListEntity], id)).now match {
              case existing : ListEntity => 
                existing.list = array.toList
                Objectify.save.entity(existing).now
          }
        })
      case Failure(message) => throw new RuntimeException(message)
  }
  
    /**
     * Deletes the entity with an idempotent work (in case other processes
     * uses the entity).
     */
  @ApiMethod(httpMethod = "delete", path = "{id}", authenticators = Array(classOf[ScalaAuthenticator]))
  def delete(user : ApiUser, @Named("id") id : JLong) : Unit = 
    // Make DELETE (update) idempotent
    Objectify.transaction(new VoidWork {
      override def vrun =
        Objectify.delete.key(Key.create(classOf[ListEntity], id)).now
    })
}