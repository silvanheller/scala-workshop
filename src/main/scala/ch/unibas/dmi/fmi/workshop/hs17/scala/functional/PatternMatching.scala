package ch.unibas.dmi.fmi.workshop.hs17.scala.functional

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Logging

import scala.util.Random

object PatternMatching extends Logging with App{

  val random = Random.nextDouble()*3

  random.toInt match {
    case 1 => log.debug("Matched one")
    case 2 => log.debug("Matched two")
    case 3 => log.debug("Wow, it works")
    case _ => log.debug("Not handled: "+random.toInt)
  }
}
