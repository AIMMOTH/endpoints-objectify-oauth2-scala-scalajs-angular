package io.cenet.endpoints

import scala.scalajs.js
import scala.scalajs.js.annotation.JSBracketAccess

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
}
@js.native
trait ClientFacade extends js.Object {
  
  /**
   * Loads an API by its name.
   * @see https://developers.google.com/api-client-library/javascript/reference/referencedocs#gapiclientloadname--------version-callback
   */
  def load(apiName : String, version : String, callback : Unit, url : String) : Unit = js.native
  
  /**
   * This returns the List API as a Facade with types.
   * This is a "hard coded" way to specify your API
   * <strong>Needs to be loaded first!</strong>
   */
  val list : ListFacade = js.native
  
  /**
   * This returns the specified API as Dynamic.
   * <strong>Needs to be loaded first!</strong>
   */
  @JSBracketAccess
  def apply(apiName : String) : js.Dynamic = js.native
}

/**
 * https://developers.google.com/api-client-library/javascript/features/promises
 */
@js.native
trait EndpointPromise extends js.Object {
  def then(opt_onFulfilled : js.Function1[EndpointResponse, Unit] = (_ : EndpointResponse) => {},
      opt_onRejected : js.Function1[EndpointResponse, Unit] = (_ : EndpointResponse) => {},
      opt_context : js.Object = null) : Unit = js.native
}
@js.native
trait EndpointResponse extends js.Object {
  val result    : js.Dynamic= js.native
  val body      : String    = js.native
  val headers   : js.Object = js.native
  val status    : Integer   = js.native
  val statusText: String    = js.native
}