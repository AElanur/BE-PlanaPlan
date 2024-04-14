package project.planaplan_backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import project.planaplan_backend.dataModels.Planboard
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.REQUIRED)
interface PlanboardRepository : JpaRepository<Planboard, String> {
    @Query("SELECT id, pb_title FROM Planboard WHERE planner_info_id IN :ids")
    fun findByPlannerInfoIdIn(ids: List<String>): List<Array<Any>>
}