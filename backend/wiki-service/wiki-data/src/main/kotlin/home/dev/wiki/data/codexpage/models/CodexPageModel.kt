package home.dev.wiki.data.codexpage.models

import home.dev.wiki.data.common.models.CodexMongoModel

class CodexPageModel(
        id: String,
        val title: String):

        CodexMongoModel(
                id = id)