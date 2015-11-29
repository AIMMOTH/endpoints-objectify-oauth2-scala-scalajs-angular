package io.cenet.angular

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExportAll

import biz.enef.angulate._
import biz.enef.angulate.core.HttpService
import biz.enef.angulate.ext.{ Route, RouteProvider }

import io.cenet.angular.list.ListController

object AngularModule extends JSApp {

  override def main(): Unit = {
    
    println("Starting angular ...")
    
    val module = angular.createModule("app", Nil)

    //  module.serviceOf[RestService]

    module.controllerOf[ListController]

    //  module.directiveOf[UserDirective]

    module.config(($routeProvider: RouteProvider) => {
      $routeProvider.
        when("/user/:id", Route(templateUrl = "/tpl/userDetails.html")).
        otherwise(Route(redirectTo = "/"))
    })

    module.run(initApp _)

    def initApp($http: HttpService) = {
      println("init angular app ...")
    }
  }
}