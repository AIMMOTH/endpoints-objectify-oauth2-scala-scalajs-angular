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
import biz.enef.angulate.Module
import io.cenet.shared.SplitValidator
import io.cenet.shared.Success
import io.cenet.shared.Failure

class ListController($scope : Scope) extends Controller  {

  var simpleInt = 0
  
  def inc() = simpleInt += 1
  def dec() = simpleInt -= 1
  
  var postInput = "value1, value2"
  var postResult = "0l"
  var getInput = "0l"
  var getOutput = ""
  
  /*
   *  This needs to be loaded before use
   *  @see io.cenet.endpoints.LocalInit	
   */
  private def listApi = EndpointsFacade.gapi.client.list.listApi
  
  /**
   *  To prevent error, check value with validator
   *  @see io.cenet.shared.SplitValidator
   */
  def post() = SplitValidator(postInput) match {
      case Success((input, _)) =>
        listApi.post(literal(csv = input))
          .then(
            (response : GoogleResponse) => {
              postResult = JSON.parse(response.body).id.asInstanceOf[String]
              $scope.$digest()
            },
            (response : GoogleResponse) =>
              window.alert(JSON.parse(response.body).error.message.asInstanceOf[String])
          )
      case Failure(message) => window.alert(message)
    }
    
  def get() = listApi.get(literal(id = getInput))
    .then((response : GoogleResponse) =>  {
      getOutput = response.body
      $scope.$digest()
    })
}