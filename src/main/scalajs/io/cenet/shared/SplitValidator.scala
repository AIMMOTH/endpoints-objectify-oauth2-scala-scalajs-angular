package io.cenet.shared

import scala.scalajs.js.annotation.JSExport

@JSExport
object SplitValidator {
  
  @JSExport
  def apply(text : String) = text.split(",").map(_.trim()).filter(_.length() > 0) match {
    case array if array.size > 1 => array
    case _ => throw new Exception("There needs to be at least two arguments split by one comma!")
  }
}