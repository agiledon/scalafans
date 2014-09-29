package com.scalafans.web

import akka.actor.{ActorRef, Props}
import akka.pattern.ask
import akka.util.Timeout
import com.scalafans.domain.actor.FansActor
import com.scalafans.domain.model.Fans
import com.scalafans.web.core.HttpServiceSupport
import scala.concurrent.ExecutionContext
import ExecutionContext.Implicits.global

trait FansHttpService extends HttpServiceSupport  {
  lazy val fansActor:ActorRef = system.actorOf(Props[FansActor])

  import scala.concurrent.duration._
  implicit val timeout = Timeout(2.seconds)

  val route =
    path("fans") {
      get {
        //url is localhost:8080/fans?fansid=1
        parameters('id.?) {
          (fansId) =>
            var result: Fans = null
            complete {
              (fansActor ? GetFans(fansId.toString)).mapTo[Fans] onSuccess {
                case fans: Fans => result = fans
              }
              result
            }
        }
      }
    }
}
