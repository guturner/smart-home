package home.dev.wiki.domain.codexpage.usecases.create

import home.dev.wiki.domain.codexpage.entities.CodexPage

interface CreateCodexPageUseCase {

    fun createCodexPage(title: String): CodexPage
}