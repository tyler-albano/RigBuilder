package com.example.rigbuilder.data

object BuildManager {

    private val partsByCategory = mutableMapOf<String, PCPart>()

    val selectedParts: List<PCPart>
        get() = partsByCategory.values.toList()

    fun addOrReplacePart(part: PCPart) {
        partsByCategory[part.category] = part
    }

    fun removePart(category: String) {
        partsByCategory.remove(category)
    }

    fun getTotalPrice(): Double {
        return partsByCategory.values.sumOf { it.price }
    }

    fun clearBuild() {
        partsByCategory.clear()
    }

    fun getCompatibilityMessage(): String {
        val cpu = partsByCategory["CPU"]
        val motherboard = partsByCategory["Motherboard"]

        if (cpu == null || motherboard == null) {
            return "Compatibility: Add both a CPU and motherboard to check compatibility."
        }

        return if (cpu.socket == motherboard.socket) {
            "Compatibility: Compatible ✅ (${cpu.socket})"
        } else {
            "Compatibility: Not compatible ❌ CPU socket ${cpu.socket} does not match motherboard socket ${motherboard.socket}."
        }
    }
}