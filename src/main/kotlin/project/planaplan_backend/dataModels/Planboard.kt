package project.planaplan_backend.dataModels

import javax.persistence.*

@Entity
@Table(name = "planboard")
data class Planboard(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val pb_title: String,
    val planner_info_id: Int
)
