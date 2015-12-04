package io.cenet.angular

import scala.scalajs.js.JSApp

import biz.enef.angulate._
import biz.enef.angulate.core.HttpService
import biz.enef.angulate.ext.{ Route, RouteProvider }

import io.cenet.angular.list.ListController

object AngularModule extends JSApp {

  override def main(): Unit = {
    
    val app = angular.createModule("app", Seq("ngRoute"))

    app.controllerOf[ListController]("ListController")
  }
}