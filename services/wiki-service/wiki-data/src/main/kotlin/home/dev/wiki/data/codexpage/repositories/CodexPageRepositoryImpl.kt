package home.dev.wiki.data.codexpage.repositories

import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import home.dev.wiki.data.codexpage.mappers.asCodexPage
import home.dev.wiki.data.codexpage.mappers.asCodexPageModel
import home.dev.wiki.data.codexpage.models.CodexPageModel
import home.dev.wiki.data.common.clients.mongodb.kmongo.CodexKMongoRepository
import home.dev.wiki.domain.codexpage.entities.CodexPage
import home.dev.wiki.domain.codexpage.repositories.CodexPageRepository
import org.litote.kmongo.getCollection

class CodexPageRepositoryImpl(
        client: MongoClient): CodexKMongoRepository<CodexPageModel>(), CodexPageRepository {

    override lateinit var collection: MongoCollection<CodexPageModel>

    init {
        val database = client.getDatabase("codexdb")
        collection = database.getCollection<CodexPageModel>("codexpages")
    }

    override fun save(codexPage: CodexPage): CodexPage {
        val codexPageModel = codexPage.asCodexPageModel()
        val savedCodexPageModel: CodexPageModel = super.save(codexPageModel)

        return savedCodexPageModel.asCodexPage()
    }

    override fun getAllCodexPages(): Sequence<CodexPage> {
        return super.getAll().map { it.asCodexPage() }
    }

    override fun getCodexPageByPageId(pageId: String): CodexPage? {
        val foundCodexPageModel = super.getById(pageId)

        return foundCodexPageModel?.asCodexPage()
    }
}