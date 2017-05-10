package ch.unibas.dmi.fmi.workshop.hs17.scala.main

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Logging

/**
  * Created by silvan on 10.05.17.
  */
class HelloLogging(name: String) extends Logging{

  def sayHello(): Unit ={
    log.info("Hello from an object. I am "+name)
  }
}

object HelloLogging extends Logging{
  def main(args: Array[String]): Unit ={
    log.info("Hello from a static function")
    val helloLogging = new HelloLogging("Batman!")
    helloLogging.sayHello()
  }
}
