package home.dev.wiki.domain.codexpage.usecases.lookup

import home.dev.wiki.domain.codexpage.entities.CodexPage
import home.dev.wiki.domain.codexpage.repositories.CodexPageRepository

class LookupCodexPageUseCaseImpl(
        private val codexPageRepository: CodexPageRepository) : LookupCodexPageUseCase {

    override fun lookupAllCodexPages(): Sequence<CodexPage>  {

        return codexPageRepository.getAllCodexPages()
    }
}