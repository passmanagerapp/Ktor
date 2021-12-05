package com.akilincarslan.routes

import com.akilincarslan.model.Quiz
import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun Route.quizRouting() {
    val quizDb = Quiz.getQuizDB()

    route("/quiz/") {
        get {
            if (quizDb.isNotEmpty()) {
                call.respond(quizDb)
            }else {
                call.respondText("No quiz found!", contentType = ContentType.Text.Plain, status = HttpStatusCode.NotFound)
            }
        }
        get("/{id}") {
           val id = call.parameters["id"] ?: return@get call.respondText("Missing id", status = HttpStatusCode.NotFound)
           val quiz = quizDb.find { it.id == id.toInt() }?:return@get call.respondText("No customer fid with id $id", status = HttpStatusCode.NotFound)
           call.respond(quiz)
        }

        param("category") {
            get {
                val categoryName = call.parameters["category"] ?: return@get call.respondText("Missing category", status = HttpStatusCode.NotFound)
                val category = quizDb.filter { it.category == categoryName }
                if (category.isEmpty()) {
                    call.respondText("No category found with the given parameter $categoryName", status = HttpStatusCode.NotFound)
                } else {
                    call.respond(category)
                }

            }
        }

    }
}
fun Application.registerQuizRouting() {
    routing {
        quizRouting()
    }
}