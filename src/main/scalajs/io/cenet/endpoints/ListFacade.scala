package io.cenet.endpoints

import scala.scalajs.js

/**
 * Example of how to implement a facade to your API.
 */
@js.native
trait ListFacade extends js.Object {
  val listApi : ListApiFacade = js.native
}
@js.native
trait ListApiFacade extends js.Object {
  def get   (parameters : IdRequest) : EndpointPromise = js.native
  def delete(parameters : IdRequest) : EndpointPromise = js.native
  def post  (parameters : TextRequest) : EndpointPromise = js.native
  def put   (parameters : UpdateRequest) : EndpointPromise = js.native
  def getAll() : EndpointPromise = js.native
}
trait IdRequest extends js.Object {
  val id : Long
}
object IdRequest {
  def apply(id : Long) = 
    js.Dynamic.literal(id = id).asInstanceOf[IdRequest]
}
trait TextRequest extends js.Object {
  val csv : String
}
object TextRequest {
  def apply(csv : String) = 
    js.Dynamic.literal(csv = csv).asInstanceOf[TextRequest]
}
trait UpdateRequest extends js.Object {
  val id : Long
  val csv : String
}
object UpdateRequest {
  def apply(id : Long, csv : String) = 
    js.Dynamic.literal(id = id, csv = csv).asInstanceOf[UpdateRequest]
}
