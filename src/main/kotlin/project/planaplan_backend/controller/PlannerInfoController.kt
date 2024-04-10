package project.planaplan_backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import project.planaplan_backend.dataModels.PlannerInfo
import project.planaplan_backend.service.PlannerInfoService

@CrossOrigin
@RestController
@RequestMapping("/planner")
class PlannerInfoController {

    @Autowired
    lateinit var plannerInfoService: PlannerInfoService

    @GetMapping("/{id}")
    fun getUser(@PathVariable id: Int): PlannerInfo? {
        return plannerInfoService.getPlannerInfo(id)
    }

    @PostMapping("/")
    fun postUser(): String {
        return "Hello User"
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: String): String {
        return "Hello User"
    }

    @PutMapping("/{id}")
    fun putUser(@PathVariable id: String): String {
        return "Hello User"
    }
}