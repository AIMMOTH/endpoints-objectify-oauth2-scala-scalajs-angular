package io.cenet.angular.list

import scala.scalajs.js
import org.scalajs.dom.raw.Window
import biz.enef.angulate.Controller
import biz.enef.angulate.Scope
import biz.enef.angulate.ScopeController
import io.cenet.endpoints.ClientFacade
import io.cenet.endpoints.EndpointsFacade
import io.cenet.endpoints.GapiFacade
import io.cenet.endpoints.GooglePromise
import io.cenet.endpoints.GoogleResponse
import scala.scalajs.js.JSON

trait ListScope extends Scope {
  var fetch : js.Function = js.native
}

class ListController($scope: js.Dynamic) extends ScopeController  {

  var response = "test"
  
  $scope.fetch = () => {
    def opt_onFulfilled= (response : GoogleResponse) => js.Dynamic.global.console.dir(JSON.parse(response.body))
    def opt_onRejected = (response : GoogleResponse) => js.Dynamic.global.console.dir(response)
    val opt_context : js.Object = null
    
    val getAll = EndpointsFacade.gapi.client.list.listApi.getAll
    getAll.then(opt_onFulfilled, opt_onRejected, opt_context)

    // Can obviously not find any with id 0l
    val get = EndpointsFacade.gapi.client.list.listApi.get(IdRequest(0l))
    get.then(opt_onFulfilled, opt_onRejected, opt_context)
  }
}
trait IdRequest extends js.Object {
  val id : Long = js.native
}
object IdRequest {
  def apply(id : Long) : IdRequest = 
    js.Dynamic.literal(id = id).asInstanceOf[IdRequest]
}