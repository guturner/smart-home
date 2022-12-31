package home.dev.wiki.api.common.responses.entities

import home.dev.wiki.api.common.responses.constants.JsonResponseStatus

class JsonSuccessResponse<T>(
    override val data: T?):

    JsonResponse<T>(
        status = JsonResponseStatus.SUCCESS,
        data = data)