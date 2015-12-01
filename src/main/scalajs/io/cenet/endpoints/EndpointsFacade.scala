package io.cenet.endpoints

import scala.scalajs.js

@js.native
object EndpointsFacade extends js.GlobalScope {
  val gapi : GapiFacade = js.native
}
@js.native
trait GapiFacade extends js.Object {
  val auth = js.Dynamic
  val client : ClientFacade = js.native
  val config = js.Dynamic
  def load(apiName : String, version : String, callback : Unit, url : String) : Unit = js.native
  val platform = js.Dynamic
  val widget = js.Dynamic
//  def request(
}
@js.native
trait ClientFacade extends js.Object {
  def load(apiName : String, version : String, callback : Unit, url : String) : Unit = js.native
  val list : ListFacade = js.native
}
@js.native
trait ListFacade extends js.Object {
  val listApi : ListApiFacade = js.native
}
@js.native
trait ListApiFacade extends js.Object {
  def get(parameters : js.Object) : GooglePromise = js.native
  def getAll() : GooglePromise = js.native
}

/**
 * https://developers.google.com/api-client-library/javascript/features/promises
 */
@js.native
trait GooglePromise extends js.Object {
  def then(opt_onFulfilled : js.Function1[GoogleResponse, js.Dynamic], opt_onRejected : js.Function1[GoogleResponse, js.Dynamic], opt_context : js.Object) : Unit = js.native
}
@js.native
trait GoogleResponse extends js.Object {
  val result    : js.Dynamic= js.native
  val body      : String    = js.native
  val headers   : js.Object = js.native
  val status    : Integer   = js.native
  val statusText: String    = js.native
}