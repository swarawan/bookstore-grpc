package id.swarawan.bookstore.config

import id.swarawan.bookstore.base.MetaResponse
import id.swarawan.bookstore.base.ResultResponse
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionHandler : ResponseEntityExceptionHandler() {

	override fun handleHttpRequestMethodNotSupported(ex: HttpRequestMethodNotSupportedException, httpHeaders: HttpHeaders, httpStatus: HttpStatus, webRequest: WebRequest): ResponseEntity<Any> {
		val metaResponse = MetaResponse().apply {
			code = HttpStatus.BAD_REQUEST.value()
			message = "Terjadi kesalahan"
			debugInfo = ex.localizedMessage
		}
		val resultResponse = ResultResponse().apply {
			status = "ERROR"
			meta = metaResponse
		}
		return ResponseEntity(resultResponse, httpStatus)
	}

	@ExceptionHandler(Exception::class)
	fun globalException(ex: Exception): ResponseEntity<ResultResponse> {
		val metaResponse = MetaResponse().apply {
			code = HttpStatus.INTERNAL_SERVER_ERROR.value()
			message = "Terjadi kesalahan"
			debugInfo = ex.localizedMessage
		}
		val resultResponse = ResultResponse().apply {
			status = "ERROR"
			meta = metaResponse
		}
		return ResponseEntity(resultResponse, HttpStatus.INTERNAL_SERVER_ERROR)
	}

	@ExceptionHandler(AppException::class)
	fun appException(ex: AppException): ResponseEntity<ResultResponse> {
		val metaResponse = MetaResponse().apply {
			code = HttpStatus.BAD_REQUEST.value()
			message = ex.localizedMessage
		}
		val resultResponse = ResultResponse().apply {
			status = "ERROR"
			meta = metaResponse
		}
		return ResponseEntity(resultResponse, HttpStatus.BAD_REQUEST)
	}

	@ExceptionHandler(DataNotFoundException::class)
	fun notFoundException(ex: DataNotFoundException): ResponseEntity<ResultResponse> {
		val metaResponse = MetaResponse().apply {
			code = HttpStatus.NOT_FOUND.value()
			message = ex.localizedMessage
		}
		val resultResponse = ResultResponse().apply {
			status = "ERROR"
			meta = metaResponse
		}
		return ResponseEntity(resultResponse, HttpStatus.NOT_FOUND)
	}
}