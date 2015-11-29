package io.cenet.shared.validator

import scala.scalajs.js.annotation.JSExport

@JSExport
object SplitValidator {
  
  @JSExport
  def apply(text : String) = text.split(",") match {
    case array@Array(a, _) => array
    case Array(a) => throw new Exception("There needs to be at least two arguments split by one comma!")
  }
}