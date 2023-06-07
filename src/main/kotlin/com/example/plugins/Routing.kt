package com.example.plugins

import io.ktor.features.ContentNegotiation
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {
    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!", contentType = ContentType.Text.Plain)
        }
    }
    routing {
        post("/"){
            call.respondText("My Test")
        }
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

    routing {
        get("/json/jackson"){
            call.respond(mapOf("hello" to "world"))
        }
    }
}
