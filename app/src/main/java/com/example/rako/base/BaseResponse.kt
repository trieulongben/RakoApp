package com.example.rako.base


open class BaseResponse<T>(var data: T? = null) {
    var statusCode: Int? = -1
    var message: String? = ""
}

class BaseResponseNoData {
    var statusCode: Int? = -1
    var message: String? = ""
}