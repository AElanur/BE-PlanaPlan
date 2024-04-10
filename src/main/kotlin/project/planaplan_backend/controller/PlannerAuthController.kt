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
    fun loginPlanner(@RequestBody plannerAuth: PlannerAuth): Boolean {
        print(plannerAuth)
        return plannerInfoService.loginPlanner(plannerAuth)
    }
}