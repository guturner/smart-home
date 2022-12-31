package home.dev.wiki.domain.codexpage.usecases.create

import home.dev.wiki.domain.codexpage.entities.CodexPage
import home.dev.wiki.domain.codexpage.repositories.CodexPageRepository
import java.util.*

class CreateCodexPageUseCaseImpl(
        private val codexPageRepository: CodexPageRepository) : CreateCodexPageUseCase {

    override fun createCodexPage(title: String): CodexPage {
        val codexPage = CodexPage(UUID.randomUUID().toString(), title)
        return codexPageRepository.save(codexPage)
    }
}