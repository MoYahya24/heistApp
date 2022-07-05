package io.heist.store.model.core.parties

enum class PartyType(val value: String) {
    DELEGATE("Delegate"), JOINT("Joint"), SOLE("Sole");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): PartyType {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}