package io.cenet.datastore

import com.googlecode.objectify.ObjectifyService
import com.googlecode.objectify.VoidWork
import io.cenet.datastore.entity.JavaEntity
import io.cenet.datastore.entity.ListEntity

object Objectify {
  
  ObjectifyService.register(classOf[JavaEntity])
  ObjectifyService.register(classOf[ListEntity])
  
  def load = ObjectifyService.ofy.load
  
  def save = ObjectifyService.ofy.save
  
  def delete = ObjectifyService.ofy.delete
  
  def transaction(work : VoidWork) = ObjectifyService.ofy.transactNew(100, work)
}