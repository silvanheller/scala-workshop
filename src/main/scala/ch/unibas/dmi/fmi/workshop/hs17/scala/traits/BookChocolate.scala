package ch.unibas.dmi.fmi.workshop.hs17.scala.traits

/**
  * We have a book which also contains chocolate. Which tax does it get?
  */
object BookChocolate extends Book with Chocolate with App{

  tax()

  override def tax(): Int = super.tax()
}
