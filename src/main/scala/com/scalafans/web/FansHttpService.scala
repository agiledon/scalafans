package com.scalafans.web

import com.scalafans.domain.model.Fans
import com.scalafans.web.core.HttpServiceSupport

trait FansHttpService extends HttpServiceSupport {
  val route =
    path("fans") {
      get {
        //url is localhost:8080/fans?fansid=1
        parameters('id.?) {
          (fansid) =>
            complete {
              Fans("1", "zhangyi")
            }
        }
      }
    }


}
