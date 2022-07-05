package io.heist.store.model.core.consents

enum class ConsentStatus(val value: String) {
    AUTHORISED("Authorised"), AWAITINGAUTHORISATION("AwaitingAuthorisation"), REJECTED("Rejected"), REVOKED("Revoked");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): ConsentStatus {
            for (b in values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }
}