package io.heist.store.model.core.consents

enum class Permission(val value: String) {
    READACCOUNTSBASIC("ReadAccountsBasic"), READACCOUNTSDETAIL("ReadAccountsDetail"), READBALANCES("ReadBalances"), READBENEFICIARIESBASIC(
        "ReadBeneficiariesBasic"
    ),
    READBENEFICIARIESDETAIL("ReadBeneficiariesDetail"), READDIRECTDEBITS("ReadDirectDebits"), READOFFERS("ReadOffers"), READPAN(
        "ReadPAN"
    ),
    READPARTY("ReadParty"), READPARTYPSU("ReadPartyPSU"), READPRODUCTS("ReadProducts"), READSCHEDULEDPAYMENTSBASIC("ReadScheduledPaymentsBasic"), READSCHEDULEDPAYMENTSDETAIL(
        "ReadScheduledPaymentsDetail"
    ),
    READSTANDINGORDERSBASIC("ReadStandingOrdersBasic"), READSTANDINGORDERSDETAIL("ReadStandingOrdersDetail"), READSTATEMENTSBASIC(
        "ReadStatementsBasic"
    ),
    READSTATEMENTSDETAIL("ReadStatementsDetail"), READTRANSACTIONSBASIC("ReadTransactionsBasic"), READTRANSACTIONSCREDITS(
        "ReadTransactionsCredits"
    ),
    READTRANSACTIONSDEBITS("ReadTransactionsDebits"), READTRANSACTIONSDETAIL("ReadTransactionsDetail");

    override fun toString(): String {
        return value
    }

    companion object {
        fun fromValue(value: String): Permission {
            for (b in Permission.values()) {
                if (b.value == value) {
                    return b
                }
            }
            throw IllegalArgumentException("Unexpected value '$value'")
        }
    }

}