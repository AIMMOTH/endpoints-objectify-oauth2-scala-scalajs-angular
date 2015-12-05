package io.cenet.angular

import biz.enef.angulate.Controller
import biz.enef.angulate.Scope
import io.cenet.endpoints.EndpointsFacade
import io.cenet.endpoints.EndpointResponse
import scala.scalajs.js.JSON
import io.cenet.shared.SplitValidator
import io.cenet.shared.Success
import io.cenet.shared.Failure
import scala.scalajs.js.Dynamic.literal
import org.scalajs.dom.window

class DynamicController($scope : Scope) extends Controller  {

  var input = "value1, value2"
  var idResult = "0l"
  
  /*
   *  This needs to be loaded before use
   *  @see io.cenet.endpoints.LocalInit	
   */
  private def listApiAsDynamic = EndpointsFacade.gapi.client("list").listApi
  
  /**
   *  To prevent error, check value with validator
   *  @see io.cenet.shared.SplitValidator
   */
  def post() = SplitValidator(input) match {
      case Success((validatedText, _)) =>
        listApiAsDynamic.post(literal(csv = validatedText))
          .then(
            (response : EndpointResponse) => {
              idResult = JSON.parse(response.body).id.asInstanceOf[String]
              $scope.$digest()
            },
            (response : EndpointResponse) =>
              window.alert(JSON.parse(response.body).error.message.asInstanceOf[String])
          )
      case Failure(message) => window.alert(message)
    }
}