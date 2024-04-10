package project.planaplan_backend.service


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import project.planaplan_backend.dataModels.PlannerInfo
import project.planaplan_backend.repository.PlannerInfoRepository

@Service
class PlannerInfoService(@Autowired private val plannerInfoRepository: PlannerInfoRepository)  {

    fun getPlannerInfo(id: Int): PlannerInfo? {
        return plannerInfoRepository.findById(id.toString()).orElse(null)
    }
}