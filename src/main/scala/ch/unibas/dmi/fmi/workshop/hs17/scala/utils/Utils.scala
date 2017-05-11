package ch.unibas.dmi.fmi.workshop.hs17.scala.utils

/**
  * Created by silvan on 11.05.17.
  */
trait Utils extends Logging{

  /**
    * http://stackoverflow.com/questions/9160001/how-to-profile-methods-in-scala
    */
  def time[A](name: String)( block: => A): A = {
    val start = System.nanoTime()
    val res = block
    val stop = System.nanoTime()
    log.debug("Elapsed time for method {} was {} ms", name, (stop-start)/1000)
    res
  }
}
