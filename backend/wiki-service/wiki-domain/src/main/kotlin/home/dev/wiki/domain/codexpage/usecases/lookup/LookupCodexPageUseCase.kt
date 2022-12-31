package home.dev.wiki.domain.codexpage.usecases.lookup

import home.dev.wiki.domain.codexpage.entities.CodexPage

interface LookupCodexPageUseCase {

    fun lookupAllCodexPages(): Sequence<CodexPage>
}