package ch.unibas.dmi.fmi.workshop.hs17.scala.main

object HelloWorld {

  def main(args: Array[String]): Unit = {
    System.out.println("Hello World")
    HelloJava.main(args)
    println("I should use a logging library anyway")  //You can do this in scala. You should really use logging libraries though.
    HelloLogging.main(args)
  }

}
