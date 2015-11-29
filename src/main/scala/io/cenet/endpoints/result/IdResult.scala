package io.cenet.endpoints.result

import java.lang.{Long => JLong}

class IdResult {
  
  var id : JLong = null
  
  def IdResult() = {}
  
  def getId = id
  def setId(newId : JLong) = id = newId
}

object IdResult {
  
  def apply(id : Long) = {
    val result = new IdResult
    result.id = id
    result
  }
}