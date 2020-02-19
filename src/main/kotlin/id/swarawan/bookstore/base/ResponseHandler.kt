package id.swarawan.bookstore.base

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.OK
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

abstract class ResponseHandler {

	fun build(msg: String = "", httpStatus: HttpStatus = OK): ResponseEntity<ResultResponse> {
		val metaResponse = MetaResponse()
		val response = ResultResponse()
		when (val processResponseObject = processResponse()) {
			is Exception -> {
				metaResponse.apply {
					code = HttpStatus.BAD_REQUEST.value()
					message = "Terjadi kesalahan"
					debugInfo = processResponseObject.localizedMessage
				}
				response.apply {
					status = "ERROR"
					meta = metaResponse
				}
			}
			else -> {
				metaResponse.apply {
					code = httpStatus.value()
					message = msg
				}
				response.apply {
					data = processResponseObject
					meta = metaResponse
				}
			}
		}

		val responseHeaders = HttpHeaders().apply {
			set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
		}

		return ResponseEntity(response, responseHeaders, httpStatus)
	}

	protected abstract fun processResponse(): Any
}