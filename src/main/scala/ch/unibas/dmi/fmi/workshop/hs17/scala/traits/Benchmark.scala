package ch.unibas.dmi.fmi.workshop.hs17.scala.traits

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Utils

/**
  * Created by silvan on 11.05.17.
  */
object Benchmark extends App with Utils{

  //First time will be slower
  var res = time("sum 10k numbers")({
    var counter = 0
    (1 to 10000).foreach(counter+=_)  //_ points to the current element in a map or foreach-call
    counter
  })
  res = time("sum 10k numbers")({
    var counter = 0
    (1 to 10000).foreach(counter+=_)  //_ points to the current element in a map or foreach-call
    counter
  })
  log.debug("sum from 1 to 10k is {}", res)
  res = time("sum 10k numbers")({
    var counter = 0
    (1 to 1000000).foreach(counter+=_)  //_ points to the current element in a map or foreach-call
    counter
  })
  log.debug("sum from 1 to 1m is {}", res)

}
