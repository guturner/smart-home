package home.dev.wiki.domain.codexpage.repositories

import home.dev.wiki.domain.codexpage.entities.CodexPage

interface CodexPageRepository {

    fun save(codexPage: CodexPage): CodexPage

    fun getAllCodexPages(): Sequence<CodexPage>

    fun getCodexPageByPageId(pageId: String): CodexPage?

    fun deleteAll(): Boolean
}