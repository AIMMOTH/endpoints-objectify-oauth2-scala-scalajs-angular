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

class ListController($scope: js.Dynamic) extends ScopeController  {

  var postInput = "test"
  var getInput = 0l
  var getOutput = ""
  val listApi = EndpointsFacade.gapi.client.list.listApi
  
  $scope.post = () => listApi.post(StringRequest(postInput))
    .then((response : GoogleResponse) => window.alert(s"OK:${response.body}"))
    
  $scope.get = () => listApi.get(IdRequest(getInput))
    .then((response : GoogleResponse) => getOutput = response.body)
}
trait IdRequest extends js.Object {
  val id : Long = js.native
}
object IdRequest {
  def apply(id : Long) : IdRequest = 
    js.Dynamic.literal(id = id).asInstanceOf[IdRequest]
}
trait StringRequest extends js.Object {
  val text : String = js.native
}
object StringRequest {
  def apply(text : String) : StringRequest = 
    js.Dynamic.literal(text = text).asInstanceOf[StringRequest]
}
