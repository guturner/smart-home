package home.dev.wiki.api.common.responses

import home.dev.wiki.api.common.responses.entities.JsonErrorResponse
import home.dev.wiki.api.common.responses.entities.JsonFailureResponse
import home.dev.wiki.api.common.responses.entities.JsonSuccessResponse

fun <T> success(data: T? = null): JsonSuccessResponse<T> {
    return JsonSuccessResponse(data = data)
}

fun failure(errors: Map<String, String>? = null, message: String? = null, errorCode: Int? = null): JsonFailureResponse<Map<String, String>?> {
    return JsonFailureResponse(message = message, data = errors, errorCode = errorCode)
}

fun <T> error(message: String, data: T? = null, errorCode: Int? = null): JsonErrorResponse<T> {
    return JsonErrorResponse(message = message, data = data, errorCode = errorCode)
}