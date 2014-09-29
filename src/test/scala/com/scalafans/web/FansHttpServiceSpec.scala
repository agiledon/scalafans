package com.scalafans.web

import com.scalafans.basic.HttpServiceSpec
import com.scalafans.domain.model.Fans
import scala.concurrent.duration._

class FansHttpServiceSpec extends HttpServiceSpec with FansHttpService {
  info("test FansHttpService")

  implicit val routeTestTimeout = RouteTestTimeout(25.seconds)

  feature("FansHttpService") {
    scenario("fetch the specific fans given id") {
      Given("Fans Id with 1")
      val fansId: String = "1"
      var result: Fans = null

      When("call FansHttpService")
      Get(s"/fans?id=$fansId") ~> route ~> check {
        status.intValue should be(200)
        result = responseAs[Fans]
      }

      Then("get the fans with id 1")
        result.id should be("1")
        result.name should be("zhangyi")
    }
  }

}
