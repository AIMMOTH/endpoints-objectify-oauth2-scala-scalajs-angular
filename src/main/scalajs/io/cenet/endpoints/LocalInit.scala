package io.cenet.endpoints

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.document

@JSExport
class LocalInit {
  
  @JSExport
  def localInit() = {
    def callback (name : String) = println(name + " API loaded")

    // Load APIs
    val url = s"${document.location.protocol}//${document.location.host}/_ah/api"
    js.Dynamic.global.console.log(url)
    EndpointsFacade.gapi.client.load("list", "v1", callback("list"), url)
  }
}
