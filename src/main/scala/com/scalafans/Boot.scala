package com.scalafans

import akka.actor.Props
import akka.io.IO
import com.scalafans.web.core.{RoutedHttpService, ActorSystemSupport, RoutesBuilder}
import spray.can.Http
import spray.routing.RouteConcatenation

object Boot extends App with RouteConcatenation
                        with ActorSystemSupport
                        with RoutesBuilder  {
  val service = system.actorOf(Props(RoutedHttpService(routes.reduce(_ ~ _))), "scalafans-service")
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
}
