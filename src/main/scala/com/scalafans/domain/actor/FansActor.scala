package com.scalafans.domain.actor

import akka.actor.Actor
import com.scalafans.domain.operation.FansOperation
import com.scalafans.web.GetFans

class FansActor extends Actor with FansOperation {
  override def receive = {
    case GetFans(id) => {
      sender ! fans(id)
    }
  }
}
