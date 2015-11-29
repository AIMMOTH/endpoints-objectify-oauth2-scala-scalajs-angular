package io.cenet.angular

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@js.native
object EndpointsFacade extends js.GlobalScope {
  val gapi : GapiFacade = js.native
}
@js.native
trait GapiFacade extends js.Object {
  val auth = js.Dynamic
  val client : ClientFacade = js.native
  val config = js.Dynamic
//  def load(apiName : String, version : String, callback : Unit, url : String) : Unit = js.native
  val platform = js.Dynamic
  val widget = js.Dynamic
}
@js.native
trait ClientFacade extends js.Object {
  def load(apiName : String, version : String, callback : Unit, url : String) : Unit = js.native
  val list : ListFacade = js.native
  val named: NamedFacade= js.native
}
@js.native
class ListFacade extends js.Object {
  val listApi : ListApiFacade = js.native
}
@js.native
class ListApiFacade extends js.Object {
  def get(id : Long) : (js.Object => Unit) = js.native
}
@js.native
class NamedFacade extends js.Object {
}

@js.native
class EndpointsFuture extends js.Object {
  
  def execute(response: js.Object) : Unit = js.native
}
