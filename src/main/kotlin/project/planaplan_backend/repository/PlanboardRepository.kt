package project.planaplan_backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import project.planaplan_backend.dataModels.Planboard
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.REQUIRED)
interface PlanboardRepository : JpaRepository<Planboard, String>