package main.scala.com.alxmyaev

import main.scala.com.alxmyaev.view.main_screen.MainController

object Application extends App {
  final private val controller = new MainController()
  controller.showMainScreen()
}
