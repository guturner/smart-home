package home.dev.wiki.api.common.responses.constants

import java.util.*

enum class JsonResponseStatus {

    SUCCESS,
    FAILURE,
    ERROR;

    override fun toString(): String {
        return name.lowercase(Locale.getDefault())
    }
}