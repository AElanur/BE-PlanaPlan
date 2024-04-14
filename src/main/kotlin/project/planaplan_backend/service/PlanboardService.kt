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
        return planboardRepository.findAllById(ids)
    }
}