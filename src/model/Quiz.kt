package com.akilincarslan.model

import kotlinx.serialization.Serializable


@Serializable
data class Quiz(
    val id:Int,
    val category:String,
    val question:String,
    val answers :List<String>,
    val rightAnswerId:String
) {

    companion object {
        fun getQuizDB() :List<Quiz> {
            return listOf(
                Quiz(1,"Geography","What is the capital of Turkey?", listOf("Istanbul","Adana","Ankara","İzmir"),"Ankara"),
                Quiz(2,"Geography","What is the capital of France?", listOf("Lille","Lyon","Metz","Paris"),"Paris"),
                Quiz(3,"Geography","What is the capital of Turkey?", listOf("Istanbul","Adana","Ankara","İzmir"),"Ankara"),
                Quiz(4,"Sport","Which player awarded Baloon'dor 2021?", listOf("L.Messi","C.Ronaldo","R.Lewandowski","K.Mbappe"),"L.Messi"),
            )
        }
    }


}