package home.dev.wiki.api.common.responses.entities

import home.dev.wiki.api.common.responses.constants.JsonResponseStatus

class JsonErrorResponse<T>(
    val message: String,
    override val data: T?,
    val errorCode: Int?):

    JsonResponse<T>(
        status = JsonResponseStatus.ERROR,
        data = data)