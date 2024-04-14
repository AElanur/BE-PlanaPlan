package project.planaplan_backend.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import project.planaplan_backend.dataModels.Planboard
import project.planaplan_backend.repository.PlanboardRepository

@Service
class PlanboardService (@Autowired private val planboardRepository: PlanboardRepository) {
    fun getPlanboard(id: Int): Planboard? {
        return planboardRepository.findById(id.toString()).orElse(null)
    }

    fun getPlanboards(ids: List<String>): List<Planboard> {
        val resultArray = planboardRepository.findByPlannerInfoIdIn(ids)
        val planboards = mutableListOf<Planboard>()
        for (i in resultArray) {
            val id = i[0] as String
            val pb_title = i[1] as String
            val planboard = Planboard(id = id, pb_title = pb_title)
            planboards.add(planboard)
        }
        return planboards
    }

    fun createNewPlanboard(planboard: Planboard) {
        planboardRepository.save(planboard)
    }
}