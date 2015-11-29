package io.cenet.angular.list

import scala.scalajs.js
import biz.enef.angulate.Controller
import io.cenet.angular.RestService
import io.cenet.angular.EndpointsFacade
import org.scalajs.dom.raw.Window
import biz.enef.angulate.Scope

class ListController($scope: Scope) extends Controller {

  var response = "test"

  def callback: Unit = {
    println("callback")
    EndpointsFacade().gapi.client.list.listApi.get(0l) { response: js.Object =>
      println("reponse:" + response)
      this.response = response.toString
    }
  }
  
  def test = "saj"

//  println("loading list ...")
  //  val window = new Window
//  EndpointsFacade().gapi.client.load("list", "v1", callback, "//localhost:8080/_ah/api")
//  EndpointsFacade().gapi.client.load("list", "v1", callback, "//" + window.location.host + "/_ah/api")
}
