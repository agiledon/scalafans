package com.scalafans.web.core

import akka.actor.Actor
import spray.routing.{HttpService, Route}

class RoutedHttpService(route: Route) extends Actor with HttpService {
  implicit def actorRefFactory = context

  override def receive = runRoute(route)
}

object RoutedHttpService {
  def apply(route: Route) = new RoutedHttpService(route)
}
