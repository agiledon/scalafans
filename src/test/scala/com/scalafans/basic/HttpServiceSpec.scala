package com.scalafans.basic

import org.scalatest.{ShouldMatchers, GivenWhenThen, FeatureSpec}
import spray.testkit.ScalatestRouteTest

class HttpServiceSpec extends FeatureSpec with GivenWhenThen with ShouldMatchers with ScalatestRouteTest
