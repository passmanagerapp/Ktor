package com.akilincarslan

import com.akilincarslan.model.Quiz
import com.akilincarslan.routes.registerQuizRouting
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0"){
        module()
    }.start(wait = true)

}


fun Application.module(testing: Boolean = false) {
    install(ContentNegotiation) {
        json()
    }
    registerQuizRouting()
    log.info("Hello from module!")

}



