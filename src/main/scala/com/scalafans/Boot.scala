package com.scalafans

import akka.actor.{Props, ActorSystem}
import akka.io.IO
import com.scalafans.web.RoutedHttpService
import spray.can.Http

object Boot extends App {
  implicit val system = ActorSystem("scalafans")
  val service = system.actorOf(Props[RoutedHttpService], "scalafans-service")
  IO(Http) ! Http.Bind(service, interface = "localhost", port = 8080)
}
