package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CSVReaderToCustom extends Simulation{

  val httpConfig = http.baseUrl("http://localhost:8080/app/")
    .header("Accept", "application/json")

  var idNumbers = (1 to 10).iterator
  val customReader = Iterator.continually(Map("gameId" -> idNumbers.next()))


  def getSpecificVideoGame()= {
    repeat(3) {
      feed(customReader)
        .exec(http("Get specific game")
        .get("videogames/${gameId}")
          //.check(jsonPath("$.name").is("${gameName}"))
          .check(status.is(200)))
    }
  }

  val scn = scenario("CSV Reader test")
    .exec(getSpecificVideoGame())


  setUp(
    scn.inject(atOnceUsers(1))
  ).protocols(httpConfig)

}
