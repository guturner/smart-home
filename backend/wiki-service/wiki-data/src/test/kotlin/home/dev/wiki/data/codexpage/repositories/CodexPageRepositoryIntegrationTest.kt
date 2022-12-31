package home.dev.wiki.data.codexpage.repositories

import com.codex.data.common.clients.mongodb.buildMongoClient
import com.mongodb.client.MongoClient
import home.dev.wiki.data.common.mongo.CodexMongoTest
import home.dev.wiki.domain.codexpage.entities.buildDummyCodexPage
import home.dev.wiki.domain.codexpage.repositories.CodexPageRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class CodexPageRepositoryIntegrationTest: CodexMongoTest() {

    lateinit var mongoClient: MongoClient

    lateinit var codexPageRepository: CodexPageRepository

    @BeforeEach
    fun setUp() {
        mongoClient = buildMongoClient(
                hostName = super.testContainerMongoHostName,
                port = super.testContainerMongoPort)

        codexPageRepository = CodexPageRepositoryImpl(
                client = mongoClient)

        codexPageRepository.deleteAll()
    }

    @Test
    fun testSaveAndGetAllCodexPages_HappyPath() {
        // Given
        val codexPage1 = buildDummyCodexPage()
        val codexPage2 = buildDummyCodexPage()

        // When
        codexPageRepository.save(codexPage1)
        codexPageRepository.save(codexPage2)

        // Then
        val foundCodexPages = codexPageRepository.getAllCodexPages()

        assertEquals(2, foundCodexPages.count())
    }

    @Test
    fun testSaveAndGetCodexPageByPageId_HappyPath() {
        // Given
        val codexPage1 = buildDummyCodexPage()
        val codexPage2 = buildDummyCodexPage()
        val codexPage3 = buildDummyCodexPage()

        // When
        codexPageRepository.save(codexPage1)
        codexPageRepository.save(codexPage2)
        codexPageRepository.save(codexPage3)

        // Then
        val foundCodexPage = codexPageRepository.getCodexPageByPageId(codexPage2.pageId)

        assertNotNull(foundCodexPage)
        assertEquals(codexPage2.pageId, foundCodexPage?.pageId)
        assertEquals(codexPage2.title, foundCodexPage?.title)
    }

    @Test
    fun testSaveAndGetCodexPageByPageId_ReturnsNull_WhenPageIdWrong() {
        // Given
        val codexPage1 = buildDummyCodexPage()
        val codexPage2 = buildDummyCodexPage()
        val codexPage3 = buildDummyCodexPage()

        // When
        codexPageRepository.save(codexPage1)
        codexPageRepository.save(codexPage2)
        codexPageRepository.save(codexPage3)

        // Then
        val foundCodexPage = codexPageRepository.getCodexPageByPageId(UUID.randomUUID().toString())

        assertNull(foundCodexPage)
    }
}