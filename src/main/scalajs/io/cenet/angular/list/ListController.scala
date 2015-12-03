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
import org.scalajs.dom.window
import js.Dynamic.global

class ListController($scope : js.Dynamic) extends ScopeController  {

  $scope.postInput = "test"
  $scope.getInput = 0l
  $scope.getOutput = ""
  
  /*
   *  Do this on call since it needs to be loaded before use
   *  @see io.cenet.endpoints.LocalInit	
   */
  private def listApi = EndpointsFacade.gapi.client.list.listApi
  
  $scope.post = () => listApi.post(StringRequest($scope.postInput.asInstanceOf[String]))
    .then((response : GoogleResponse) => window.alert(s"OK:${response.body}"))
    
  $scope.get = () => {
    global.console.dir("c:" + $scope.getInput)
    listApi.get(IdRequest($scope.getInput))
    .then((response : GoogleResponse) => {
      js.Dynamic.global.console.dir(response.body)
      $scope.getOutput = response.body
      })
  }
}
trait IdRequest extends js.Object {
  val id : js.Dynamic = js.native
}
object IdRequest {
  def apply(id : js.Dynamic) : IdRequest = 
    js.Dynamic.literal(id = id).asInstanceOf[IdRequest]
}
trait StringRequest extends js.Object {
  val csv : String = js.native
}
object StringRequest {
  def apply(csv : String) : StringRequest = 
    js.Dynamic.literal(csv = csv).asInstanceOf[StringRequest]
}
