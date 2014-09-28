package com.scalafans.web.core

import com.scalafans.web.FansHttpService
import spray.routing.Route

trait RoutesBuilder {
     val routes: List[Route] = List(
        new FansHttpService with ActorSystemSupport {}.route
     )
}
