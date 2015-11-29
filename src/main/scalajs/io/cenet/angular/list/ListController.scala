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

class ListController($scope: Scope) extends Controller {

  var response = "test"

  def callback: Unit = {
    println("callback")
    val t = EndpointsFacade
    t.gapi.client.list.listApi.get(0l) { response: js.Object =>
      this.response = response.toString
    }
  }
  
  val facade = EndpointsFacade
  facade.gapi.client.load("list", "v1", callback, "//localhost:8080/_ah/api") // TypeError: Cannot read property 'load' of undefined
}
