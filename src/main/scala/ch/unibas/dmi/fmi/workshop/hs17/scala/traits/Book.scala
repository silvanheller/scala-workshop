package ch.unibas.dmi.fmi.workshop.hs17.scala.traits

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Logging

trait Book extends Logging {

  def tax(): Int = {
    log.debug("Fetching book tax")
    1
  }
}
