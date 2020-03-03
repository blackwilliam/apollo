package com.crm.view

import scala.io.StdIn

class CustomerView {
	var loop: Boolean = false
  	var key: Int = _

  	def mainMenu(): Unit = {
	  do{
		println("--------------客户管理系统软件------------------")
		println("              1. 添加客户                      ")
		println("              2. 修改客户                      ")
		println("              3. 删除客户                      ")
		println("              4. 客户列表                      ")
		println("              5. 退出                         ")
		println("              请选择 1-5                      ")
		println("----------------------------------------------")

		key = StdIn.readInt()
		key match {
		  	case 1 => println("1")
			case 2 => println("2")
			case 3 => println("3")
			case 4 => println("4")
			case 5 => println("5")
			case _ => println("请输入正确编号")
		}
	  }while(loop)
	}

}
