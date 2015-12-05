package io.cenet.angular

import biz.enef.angulate.Controller
import biz.enef.angulate.Scope
import io.cenet.endpoints.EndpointResponse
import io.cenet.endpoints.EndpointsFacade
import scala.scalajs.js
import scala.scalajs.js.Any.fromFunction1
import io.cenet.endpoints.IdRequest

class FacadeController($scope : Scope) extends Controller {
  
  var input = "0"
  var entityJson = ""
  
  /*
   *  This needs to be loaded before use
   *  @see io.cenet.endpoints.LocalInit	
   */
  private def listApi = EndpointsFacade.gapi.client.list.listApi
  
  def get() = listApi.get(IdRequest(input.toLong))
    .then((response : EndpointResponse) =>  {
      entityJson = response.body.toString
      $scope.$digest()
    })
}