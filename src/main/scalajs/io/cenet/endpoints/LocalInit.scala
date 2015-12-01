package io.cenet.endpoints

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport

@JSExport
class LocalInit {
  
  @JSExport
  def localInit = {
    def callback (name : String) = println(name + " API loaded")
    // Load APIs
    EndpointsFacade.gapi.client.load("list", "v1", callback("list"), "//localhost:8080/_ah/api")
  }
}