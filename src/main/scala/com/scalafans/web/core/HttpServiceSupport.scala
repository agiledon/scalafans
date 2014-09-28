package com.scalafans.web.core

import akka.actor.ActorSystem
import org.json4s.{Formats, DefaultFormats}
import spray.httpx.Json4sSupport
import spray.routing.{Route, Directives}

trait HttpServiceSupport extends Directives with Json4sSupport {

  implicit val system: ActorSystem

  implicit def json4sFormats: Formats = DefaultFormats

  def route: Route
}
