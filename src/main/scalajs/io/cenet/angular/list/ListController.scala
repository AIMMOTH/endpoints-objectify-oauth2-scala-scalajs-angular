package io.cenet.angular.list

import scala.scalajs.js

import org.scalajs.dom.raw.Window

import biz.enef.angulate.Controller
import biz.enef.angulate.Scope
import biz.enef.angulate.ScopeController
import io.cenet.endpoints.ClientFacade
import io.cenet.endpoints.EndpointsFacade
import io.cenet.endpoints.GapiFacade

trait ListScope extends Scope {
  var fetch : js.Function = js.native
}

class ListController($scope: js.Dynamic) extends ScopeController  {

  var response = "test"
  $scope.fetch = () => {
    js.Dynamic.global.console.dir(EndpointsFacade.gapi.client.list.listApi)
    EndpointsFacade.gapi.client.list.listApi.getAll.execute (_)
//    EndpointsFacade.gapi.client.list.listApi.getAll { response : js.Object =>
//      js.Dynamic.global.console.dir(response)
//      this.response = response.toString
//    }
  }
  
  def callback = js.Dynamic.global.console.dir("Loading ...")
  
  $scope.load = () => EndpointsFacade.gapi.client.load("list", "v1", callback, "//localhost:8080/_ah/api")
}
