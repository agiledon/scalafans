package com.scalafans.domain.operation

import com.scalafans.domain.model.Fans

trait FansOperation {
    def fans(id: String): Fans = Fans("1", "zhangyi")
}
