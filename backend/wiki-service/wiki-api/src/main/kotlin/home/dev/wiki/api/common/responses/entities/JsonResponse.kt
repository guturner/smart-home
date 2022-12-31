package home.dev.wiki.api.common.responses.entities

import home.dev.wiki.api.common.responses.constants.JsonResponseStatus

abstract class JsonResponse<T>(
        status: JsonResponseStatus,
        open val data: T?) {

    val status: String = status.toString()
}