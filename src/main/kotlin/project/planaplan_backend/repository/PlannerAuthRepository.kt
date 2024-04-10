package project.planaplan_backend.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import project.planaplan_backend.dataModels.PlannerAuth
import javax.transaction.Transactional

@Repository
@Transactional(Transactional.TxType.MANDATORY)
interface PlannerAuthRepository : JpaRepository<PlannerAuth, String>