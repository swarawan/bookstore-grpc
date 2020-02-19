package id.swarawan.bookstore.base

import org.springframework.http.HttpStatus

data class MetaResponse(
	var code: Int = HttpStatus.OK.value(),
	var message: String = "",
	var debugInfo: String = ""
)