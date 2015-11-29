package io.cenet.angular.list

import scala.scalajs.js
import biz.enef.angulate.Controller
import io.cenet.angular.RestService
import io.cenet.angular.EndpointsFacade
import org.scalajs.dom.raw.Window

class ListController extends Controller {
  
  def callback: Unit = {
    EndpointsFacade().gapi.client.list.listApi.get(0l) { response: js.Object =>
      
    }
  }
  
  val window = new Window
  EndpointsFacade().gapi.client.load("list", "v1", callback, "//" + window.location.host + "/_ah/api")
}
