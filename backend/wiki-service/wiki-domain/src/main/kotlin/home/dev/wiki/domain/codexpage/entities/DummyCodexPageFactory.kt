package home.dev.wiki.domain.codexpage.entities

import home.dev.wiki.domain.common.testutils.getDummySentence
import home.dev.wiki.domain.common.testutils.getDummyUUID

fun buildDummyCodexPage(
        pageId: String = getDummyUUID(),
        title: String = getDummySentence()): CodexPage {

    return CodexPage(
            pageId = pageId,
            title = title)
}