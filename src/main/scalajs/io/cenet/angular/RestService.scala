package io.cenet.angular

import biz.enef.angulate.Service
import biz.enef.angulate.core.HttpService
import biz.enef.angulate.core.HttpPromise
import biz.enef.angulate.core.HttpConfig

class RestService($http : HttpService) extends Service {
  
  def post[T](url : String, data : scala.scalajs.js.Any) : HttpPromise[T] = {
    $http.post(url, data, HttpConfig(("authorization", "Bearer abc123")))
  }
  
  def get[T](url : String) = $http.get(url, HttpConfig(("authorization", "Bearer abc123")))
}