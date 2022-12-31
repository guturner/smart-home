package home.dev.wiki.data.common.mongo

import home.dev.wiki.data.common.logs.logger
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.testcontainers.shaded.org.awaitility.Awaitility.await

abstract class CodexMongoTest {

    companion object {
        private val mongoContainer = buildMongoTestContainer()

        private val log by logger()

        @BeforeAll
        @JvmStatic
        fun setUpClass() {
            log.info("Starting Mongo docker container...")

            mongoContainer.start()
            await().until { mongoContainer.isRunning }

            log.info("Mongo docker container started!")
        }

        @AfterAll
        @JvmStatic
        fun tearDownClass() {
            log.info("Stopping Mongo docker container...")

            mongoContainer.stop()
            await().until { !mongoContainer.isRunning }

            log.info("Mongo docker container stopped!")
        }
    }

    protected val testContainerMongoHostName: String = mongoContainer.host

    protected val testContainerMongoPort: Int = mongoContainer.getMappedPort(27017)

    protected val testContainerMongoDatabaseName: String = "test"
}