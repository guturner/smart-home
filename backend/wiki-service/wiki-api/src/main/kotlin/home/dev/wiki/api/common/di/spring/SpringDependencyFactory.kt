package home.dev.wiki.api.common.di.spring

import com.codex.data.common.clients.mongodb.buildMongoClient
import com.mongodb.client.MongoClient
import home.dev.wiki.data.codexpage.repositories.CodexPageRepositoryImpl
import home.dev.wiki.domain.codexpage.repositories.CodexPageRepository
import home.dev.wiki.domain.codexpage.usecases.create.CreateCodexPageUseCase
import home.dev.wiki.domain.codexpage.usecases.create.CreateCodexPageUseCaseImpl
import home.dev.wiki.domain.codexpage.usecases.lookup.LookupCodexPageUseCase
import home.dev.wiki.domain.codexpage.usecases.lookup.LookupCodexPageUseCaseImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringDependencyFactory {

    @Bean
    fun wireMongoClient(): MongoClient {
        return buildMongoClient(
            username = "codex-localadmin-username",
            password = "codex-localadmin-password",
            hostName = "localhost",
            port = 27017
        )
    }

    @Bean
    fun wireCodexPageRepository(
        mongoClient: MongoClient): CodexPageRepository {

        return CodexPageRepositoryImpl(
            client = mongoClient
        )
    }

    @Bean
    fun wireCreateCodexPageUseCase(
        codexPageRepository: CodexPageRepository): CreateCodexPageUseCase {

        return CreateCodexPageUseCaseImpl(
            codexPageRepository = codexPageRepository
        )
    }

    @Bean
    fun wireLookupCodexPageUseCase(
        codexPageRepository: CodexPageRepository): LookupCodexPageUseCase {

        return LookupCodexPageUseCaseImpl(
            codexPageRepository = codexPageRepository
        )
    }
}