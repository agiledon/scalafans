package com.scalafans.web

trait RequestMessage

case class GetFans(id: String) extends RequestMessage
