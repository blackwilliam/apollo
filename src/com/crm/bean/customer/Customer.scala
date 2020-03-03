package com.crm.bean.customer

class Customer {

  	var id: Int = _
	var name: String = _
    var age: Int = _
  	var gender: Char = _
  	var phone: String = _
  	var email: String = _

  	def this(id: Int, name: String, age: Int, gender: Char,
			 phone: String, email: String) {
	  	this
		this.id = id
		this.name = name
		this.age = age
		this.gender = gender
		this.phone = phone
		this.email = email
	}
}
