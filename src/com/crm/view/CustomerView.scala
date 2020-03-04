package com.crm.view

import scala.io.StdIn
import com.crm.service.CustomerService


class CustomerView {
	var loop: Boolean = true
  	var key: Int = _

  	val customerService = new CustomerService()

  	def mainMenu(): Unit = {
	  do{
		  println("--------------客户管理系统软件------------------")
		  println("              1. 添加客户                      ")
		  println("              2. 修改客户                      ")
		  println("              3. 删除客户                      ")
		  println("              4. 客户列表                      ")
		  println("              5. 退出                         ")
		  println("              请选择 1-5                      ")
		  println("---------------------------------------------")

		  key = StdIn.readInt()
		  key match {
			  case 1 => add()
			  case 2 => modify()
			  case 3 => delete()
			  case 4 => list()
			  case 5 => quit()
			  case _ => loop = false
		  }
		}while(loop)
	}
	def quit(): Unit = {
	  	println("------------------再见---------------------------")
	  	loop = false
	}
  	def modify(): Unit = {
	  	println("------------------修改客户------------------------")
	  	println("请选择修改的编号:")
		val id: Int = StdIn.readInt()
	  	if (id <= 0) {
		  println("编号不存在")
		} else {
		  val index = customerService.findIndexById(id)
		  if (index <= 0) println("编号不存在")
		  else {
			println("请输入姓名：")
			val name = StdIn.readLine()
			println("请输入年龄")
			val age = StdIn.readInt()
			println("请输入性别")
			val gender = StdIn.readChar()
			println("请输入电话")
			val phone = StdIn.readLine()
			println("请输入邮箱")
			val email = StdIn.readLine()
			customerService.modify(id, name, age, gender, phone, email)
		  }
		}
	}
  	def delete(): Unit = {
	  	println("------------------删除客户------------------------")
		println("请选择要删除的客户编号")
	  	val id: Int = StdIn.readInt()
	    if (id <= 0) {
		  println("编号不存在")
		} else {
		  println("确定是否删除(Y/N):")
		  val choice: Char = StdIn.readChar().toLower
		  if (choice == 'y') customerService.delete(id)
		}
	}
  	def add(): Unit = {
	  	println("------------------添加客户------------------------")
	  	println("姓名：")
	  	val name: String = StdIn.readLine()
	  	println("年龄：")
	  	val age: Int = StdIn.readInt()
	  	println("性别：")
	  	val gender: Char = StdIn.readChar()
	  	println("电话：")
	  	val phone: String = StdIn.readLine()
	  	println("邮箱：")
	  	val email: String = StdIn.readLine()
	  	customerService.add(name, age, gender, phone, email)
	}

  	def list(): Unit = {
		println("------------------客户列表------------------------")
	    println("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱\t\t")
	  	val customers = customerService.list()
	  	for (c <- customers) {
			println(c)
		}
	  	println("------------------------------------------------")
	}

}
