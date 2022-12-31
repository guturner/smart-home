package home.dev.wiki.data.common.mongo

import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName

fun buildMongoTestContainer(): MongoDBContainer {

    return MongoDBContainer(DockerImageName.parse("mongo:latest"))
}