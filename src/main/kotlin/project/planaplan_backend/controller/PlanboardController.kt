package project.planaplan_backend.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import project.planaplan_backend.dataModels.Planboard
import project.planaplan_backend.service.PlanboardService

@CrossOrigin
@RestController
@RequestMapping("/planboard")
class PlanboardController {

    @Autowired
    lateinit var planboardService: PlanboardService

    @GetMapping("/{id}")
    fun getPlanboard(@PathVariable id: Int): Planboard? {
            return planboardService.getPlanboard(id)
    }

    @GetMapping("/all/{id}")
    fun getPlanboards(@PathVariable id: List<String>): List<Planboard> {
        return planboardService.getPlanboards(id)
    }
}