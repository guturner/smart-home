package home.dev.wiki.api.codexpage.controllers

import home.dev.wiki.api.codexpage.dtos.CreateCodexPageRequest
import home.dev.wiki.api.codexpage.dtos.CreateCodexPageResponse
import home.dev.wiki.api.codexpage.mappers.asCreateCodexPageResponse
import home.dev.wiki.api.common.responses.entities.JsonResponse
import home.dev.wiki.api.common.responses.success
import home.dev.wiki.domain.codexpage.entities.CodexPage
import home.dev.wiki.domain.codexpage.usecases.create.CreateCodexPageUseCase
import home.dev.wiki.domain.codexpage.usecases.lookup.LookupCodexPageUseCase
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CodexPageController(
        private val createCodexPageUseCase: CreateCodexPageUseCase,
        private val lookupCodexPageUseCase: LookupCodexPageUseCase) {

    @CrossOrigin
    @GetMapping(path = ["/api/v1/codexPages"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun lookupCodexPages_V1(): ResponseEntity<JsonResponse<List<CodexPage>>> {
        val codexPages = lookupCodexPageUseCase.lookupAllCodexPages()
        return ResponseEntity.ok(success(codexPages.toList()))
    }

    @CrossOrigin
    @PostMapping(path = ["/api/v1/codexPages"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createCodexPage_V1(@RequestBody request: CreateCodexPageRequest): ResponseEntity<JsonResponse<CreateCodexPageResponse>> {
        val codexPage = createCodexPageUseCase.createCodexPage(request.title)
        return ResponseEntity.ok(success(codexPage.asCreateCodexPageResponse()))
    }
}