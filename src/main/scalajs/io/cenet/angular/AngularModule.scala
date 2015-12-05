package io.cenet.angular

import scala.scalajs.js.JSApp
import biz.enef.angulate.angular

object AngularModule extends JSApp {

  override def main(): Unit = {
    
    val app = angular.createModule("app", Seq("ngRoute"))

    app.controllerOf[SimpleController]("SimpleController")
    app.controllerOf[DynamicController]("DynamicController")
    app.controllerOf[FacadeController]("FacadeController")
  }
}