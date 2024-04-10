package project.planaplan_backend.dataModels

import javax.persistence.*

@Entity
@Table(name = "planner_info")
data class PlannerInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: String = "",
    var name: String = "",
    var lastname: String = "",
    var email: String = "",
    var auth_id: String = ""
)