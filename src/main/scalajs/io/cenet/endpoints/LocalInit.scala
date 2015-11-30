package io.cenet.endpoints

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import io.cenet.endpoints.EndpointsFacade

@JSExport
class LocalInit {
  
  @JSExport
  def localInit = {
    def callback = {
      println("haj at local init")
//      EndpointsFacade.gapi.client.list.listApi.getAll { response : js.Object =>
//        js.Dynamic.global.console.dir(response)
//      }
    }
      println("local init ...")
    // Load APIs
//    EndpointsFacade.gapi.client.load("list", "v1", callback, "//localhost:8080/_ah/api")
  }
}