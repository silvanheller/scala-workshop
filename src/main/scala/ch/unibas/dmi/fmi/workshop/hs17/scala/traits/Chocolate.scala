package ch.unibas.dmi.fmi.workshop.hs17.scala.traits

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Logging


trait Chocolate extends Logging{

  def tax(): Int = {
    log.debug("Fetching chocolate tax")
    2
  }
}
