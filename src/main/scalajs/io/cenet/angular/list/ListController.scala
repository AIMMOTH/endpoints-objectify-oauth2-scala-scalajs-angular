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
import js.Dynamic.literal

class ListController($scope : js.Dynamic) extends ScopeController  {

  $scope.postInput = "test"
  $scope.postResult = ""
  $scope.getInput = 0l
  $scope.getOutput = ""
  
  /*
   *  This needs to be loaded before use
   *  @see io.cenet.endpoints.LocalInit	
   */
  private def listApi = EndpointsFacade.gapi.client.list.listApi
  
  /**
   *  To prevent error, check value with validator
   *  @see io.cenet.shared.SplitValidator
   */
  $scope.post = () => listApi.post(literal(csv = $scope.postInput))
    .then(
      (response : GoogleResponse) => $scope.postResult = JSON.parse(response.body).id,
      (response : GoogleResponse) => window.alert(JSON.parse(response.body).error.message.asInstanceOf[String])
    )
    
  $scope.get = () => listApi.get(literal(id = $scope.getInput))
    .then((response : GoogleResponse) =>  $scope.getOutput = response.body)
}
