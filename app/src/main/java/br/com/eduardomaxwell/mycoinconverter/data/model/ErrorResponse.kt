package br.com.eduardomaxwell.mycoinconverter.data.model

data class ErrorResponse (
    val status: Long,
    val code: String,
    val message: String
)
