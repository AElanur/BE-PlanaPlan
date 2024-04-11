package project.planaplan_backend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import project.planaplan_backend.dataModels.PlannerAuth
import project.planaplan_backend.repository.PlannerAuthRepository

@Service
class PlannerAuthService(@Autowired private val plannerService: PlannerAuthRepository) {
    fun loginPlanner(planner: PlannerAuth): Boolean {
        return plannerService.exists(Example.of(planner))
    }

    fun getPlannerInfo(id: Int): Boolean {
        return plannerService.existsById(id.toString())
    }
}