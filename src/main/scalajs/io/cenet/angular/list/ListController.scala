package io.cenet.angular.list

import org.scalajs.dom.Console
import scala.scalajs.js
import biz.enef.angulate.Controller
import io.cenet.angular.RestService
import io.cenet.angular.EndpointsFacade
import org.scalajs.dom.raw.Window
import biz.enef.angulate.Scope
import io.cenet.angular.GapiFacade
import io.cenet.angular.ClientFacade
import biz.enef.angulate.ScopeController

trait ListScope extends Scope {
  var fetch : js.Function = js.native
}

class ListController($scope: js.Dynamic) extends ScopeController  {

  var response = "test"
  $scope.fetch = () => {
    EndpointsFacade.gapi.client.list.listApi.getAll.execute (_)
//    EndpointsFacade.gapi.client.list.listApi.getAll { response : js.Object =>
//      js.Dynamic.global.console.dir(response)
//      this.response = response.toString
//    }
  }
  
  def callback = js.Dynamic.global.console.dir("Loading ...")
  
  $scope.load = () => EndpointsFacade.gapi.client.load("list", "v1", callback, "//localhost:8080/_ah/api")
}
