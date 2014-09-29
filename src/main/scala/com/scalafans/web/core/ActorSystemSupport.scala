package com.scalafans.web.core

import akka.actor.ActorSystem

trait ActorSystemSupport {
  implicit lazy val system = ActorSystem("scalafans")
}
