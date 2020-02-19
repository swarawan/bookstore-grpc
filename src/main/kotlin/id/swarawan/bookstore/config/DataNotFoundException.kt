package id.swarawan.bookstore.config

class DataNotFoundException(private val messageError: String) : Exception("$messageError tidak ditemukan")