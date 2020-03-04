package com.crm.service

import scala.collection.mutable.ArrayBuffer
import com.crm.bean.Customer
import util.control.Breaks._

class CustomerService {

  	val customers = new ArrayBuffer[Customer]

  	def add(name: String, age: Int, gender: Char, phone: String, email: String) = {
		customers.append(
		  new Customer(customers.length+1, name, age, gender, phone, email))
  	}
	def findIndexById(id: Int): Int = {
	  var index: Int = -1
	  breakable {
		for (c <- this.customers) {
			index += 1
		  	if (c.id == id) {
			  break()
			}
		}
	  }
	  index
	}
  	def modify(id: Int, name: String, age: Int, gender: Char, phone: String, email: String): Unit = {
	  	breakable {
		  for (c <- customers) {
			if (c.id == id) {
			  c.name = name
			  c.age = age
			  c.email = email
			  c.phone = phone
			  c.gender = gender
			}
			break
		  }
		}
	}
  	def delete(id: Int): Unit = {
	  val index: Int = findIndexById(id)
	  customers.remove(index)
	}
	def list(): ArrayBuffer[Customer] = customers
}
