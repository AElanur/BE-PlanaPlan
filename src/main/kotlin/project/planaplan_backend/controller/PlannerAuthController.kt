package project.planaplan_backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import project.planaplan_backend.dataModels.PlannerAuth
import project.planaplan_backend.service.PlannerAuthService

@CrossOrigin
@RestController
@RequestMapping("/planner")
class PlannerAuthController {

    @Autowired
    lateinit var plannerInfoService: PlannerAuthService

    @PostMapping("/login")
    fun loginPlanner(@RequestBody plannerAuth: PlannerAuth): Map<String, String>? {
        return plannerInfoService.loginPlanner(plannerAuth)
    }

    @PostMapping("/login/verify-token")
    fun verifyToken(@RequestHeader("Authorization") authHeader: String): Boolean {
        val token = authHeader.removePrefix("Bearer ").trim()
        return plannerInfoService.verifyToken(token)
    }

    @GetMapping("/login/{id}")
    fun getUser(@PathVariable id: Int): Boolean? {
        return plannerInfoService.getPlannerInfo(id)
    }
}