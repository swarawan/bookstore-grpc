package id.swarawan.bookstore.config

class AppException(private val messageError: String = "Terjadi kesalahan") : Exception(messageError)