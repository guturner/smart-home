package home.dev.wiki.data.codexpage.mappers

import home.dev.wiki.data.codexpage.models.CodexPageModel
import home.dev.wiki.domain.codexpage.entities.CodexPage

fun CodexPage.asCodexPageModel(): CodexPageModel {
    return CodexPageModel(
            id = this.pageId,
            title = this.title
    )
}

fun CodexPageModel.asCodexPage(): CodexPage {
    return CodexPage(
            pageId = this.id,
            title = this.title
    )
}