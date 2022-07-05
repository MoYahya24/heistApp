/*
 * Copyright (c) 2020. Weird ( The Weird Science Holding B.V. )
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.heist.store.model.core.debits

import io.heist.store.model.core.accounts.Account
import io.heist.store.model.core.amounts.Amount
import java.time.OffsetDateTime

data class Debit (

    val id: String? = null,

    val ref: String? = null,

    val mandateId: String? = null,

    val status: String? = "Active",

    val name: String? = null,

    val prev: OffsetDateTime? = null,

    val frequency: String? = null,

    val account: Account? = null,

    val amount: Amount? = null

) {
    val debitStatus = DirectDebitStatus.fromValue(status!!)
}
