package home.dev.wiki.api.codexpage.mappers

import home.dev.wiki.api.codexpage.dtos.CreateCodexPageResponse
import home.dev.wiki.domain.codexpage.entities.CodexPage

fun CodexPage.asCreateCodexPageResponse(): CreateCodexPageResponse {

    return CreateCodexPageResponse(
        pageId = this.pageId,
        title = this.title
    )
}