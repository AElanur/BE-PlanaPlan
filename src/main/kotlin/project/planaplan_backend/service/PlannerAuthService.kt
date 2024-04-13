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
    fun loginPlanner(planner: PlannerAuth): Map<String, String>? {
        val user = plannerService.findByUsernameAndPassword(planner.username, planner.password) ?: return null
        val algorithm = Algorithm.HMAC256("secret")
            val token = JWT.create()
                .withIssuer("PlanaPlan_Backend")
                .withClaim("id", user.id)
                .withExpiresAt(Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000)) // 1 day
                .sign(algorithm)

            return mapOf("token" to token, "id" to user.id)
    }

    fun getPlannerInfo(id: Int): Boolean {
        return plannerService.existsById(id.toString())
    }

    fun verifyToken(token: String): Boolean {
        return try {
            val algorithm = Algorithm.HMAC256("secret")
            val verifier = JWT.require(algorithm)
                .withIssuer("PlanaPlan_Backend")
                .build()
            verifier.verify(token)
            true
        } catch (exception: Exception) {
            println("Error verifying token: ${exception.message}")
            false
        }
    }
}