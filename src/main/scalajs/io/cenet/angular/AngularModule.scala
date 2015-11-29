package io.cenet.angular

import biz.enef.angulate._
import biz.enef.angulate.core.HttpService
import biz.enef.angulate.ext.{ Route, RouteProvider }

class AngularModule {

  val module = angular.createModule("app")

  module.serviceOf[RestService]

  module.controllerOf[UserCtrl]

//  module.directiveOf[UserDirective]

  module.config(($routeProvider: RouteProvider) => {
    $routeProvider.
      when("/user/:id", Route(templateUrl = "/tpl/userDetails.html")).
      otherwise(Route(redirectTo = "/"))
  })

  module.run(initApp _)

  def initApp($http: HttpService) = {

  }
}