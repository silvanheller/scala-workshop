package ch.unibas.dmi.fmi.workshop.hs17.scala.functional

import ch.unibas.dmi.fmi.workshop.hs17.scala.utils.Logging
import org.apache.commons.lang3.{RandomStringUtils, RandomUtils}

import scala.util.Random

/**
  * Created by silvan on 10.05.17.
  */
object MapDemo extends Logging with App {

  //Case classes are mini-classes which allow us to write less code
  case class Person(name: String, age: Int)

  //generate 10 persons
  val persons = Seq.fill(10)(Person(RandomStringUtils.randomAlphabetic(10), (Random.nextFloat() * 30 + 20).toInt))

  log.debug(persons.mkString(" | "))

  //For each person, we generate their kid
  val children = persons.map(person => {
    Person("Child of Mister "+person.name, person.age-30)
  })

  log.debug(children.mkString(" | "))

}
