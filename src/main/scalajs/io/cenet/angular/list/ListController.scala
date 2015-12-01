package io.cenet.angular.list

import scala.scalajs.js
import org.scalajs.dom.raw.Window
import biz.enef.angulate.Controller
import biz.enef.angulate.Scope
import biz.enef.angulate.ScopeController
import io.cenet.endpoints.ClientFacade
import io.cenet.endpoints.EndpointsFacade
import io.cenet.endpoints.GapiFacade
import io.cenet.endpoints.Response

trait ListScope extends Scope {
  var fetch : js.Function = js.native
}

class ListController($scope: js.Dynamic) extends ScopeController  {

  var response = "test"
  
  $scope.fetch = () => {
    def opt_onFulfilled= (response : Response) => js.Dynamic.global.console.dir(response)
    def opt_onRejected = (response : Response) => js.Dynamic.global.console.dir(response)
    val opt_context : js.Object = null
    
    val getAll = EndpointsFacade.gapi.client.list.listApi.getAll
    js.Dynamic.global.console.dir(getAll)
    getAll.then(opt_onFulfilled, opt_onRejected, opt_context)

    // This fails with "cannot find parameter 'id'"
//    val get = EndpointsFacade.gapi.client.list.listApi.get(Map("id" -> 0l))
//    js.Dynamic.global.console.dir(get)
//    get.then(opt_onFulfilled, opt_onRejected, opt_context)
  }
}
