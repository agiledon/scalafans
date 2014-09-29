package com.scalafans.web.core

import akka.actor.ActorSystem
import org.json4s.{DefaultFormats, Formats}
import spray.httpx.Json4sSupport
import spray.routing.{Directives, Route}

trait HttpServiceSupport extends Directives with Json4sSupport {

  implicit val system: ActorSystem

  implicit def json4sFormats: Formats = DefaultFormats

  def route: Route
}
