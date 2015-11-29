package io.cenet.angular

import scala.scalajs.js

class EndpointsFacade extends js.Object {
  val gapi : GapiFacade = js.native
}
class GapiFacade extends js.Object {
  val client : ClientFacade = js.native
}
class ClientFacade extends js.Object {
  def load(apiName : String, version : String, callback : Unit, url : String) : Unit = js.native
  val list : ListFacade = js.native
  val named: NamedFacade= js.native
}
class ListFacade extends js.Object {
  val listApi : ListApiFacade = js.native
}
class ListApiFacade extends js.Object {
  // Mirror ListApi.scala
  def get(id : Long) : (js.Object => Unit) = js.native
}
class NamedFacade extends js.Object {
}

object EndpointsFacade {
  
  lazy val facade = new EndpointsFacade
  
  def apply() = facade
}

class EndpointsFuture extends js.Object {
  
  def execute(response: js.Object) : Unit = js.native
}
