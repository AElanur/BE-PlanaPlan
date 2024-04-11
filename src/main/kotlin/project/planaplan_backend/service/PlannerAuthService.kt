package project.planaplan_backend.service

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service
import project.planaplan_backend.dataModels.PlannerAuth
import project.planaplan_backend.repository.PlannerAuthRepository
import java.util.*

@Service
class PlannerAuthService(@Autowired private val plannerService: PlannerAuthRepository) {
    fun loginPlanner(planner: PlannerAuth): String? {
            val userExists = plannerService.exists(Example.of(planner))
            if (!userExists) {
                return null
            }
            val algorithm = Algorithm.HMAC256("secret")
            val token = JWT.create()
                .withIssuer("PlanaPlan_Backend")
                .withClaim("username", planner.username)
                .withExpiresAt(Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 1 day
                .sign(algorithm)
            return token
    }

    fun getPlannerInfo(id: Int): Boolean {
        return plannerService.existsById(id.toString())
    }
}