package ch.unibas.dmi.fmi.workshop.hs17.scala.method

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Logging

/**
  * Extends App, which makes it runnable :)
  * Watch how the 'with' makes multiple inheritance possible
  */
class MethodDemo extends App with Logging {

  log.debug("Calling noBrackets gives: " + noBrackets)
  noReturnStatement //The scala convention says you should have ()-brackets for methods which are not simple getters. We break that on purpose here.

  def noReturnStatement: Int = {
    var counter = 0
    for (i <- 1 to 10) {
      log.debug("current i value is {}", i)
      counter += 1
    }
    val list = 1 to 10
    list.foreach(el => {
      log.debug("current i value is {}", el)
    })
    counter
  }

  def declareReturn: Int = 1

  def noBrackets = 1
}
