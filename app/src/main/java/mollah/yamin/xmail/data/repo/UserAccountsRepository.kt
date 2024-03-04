package mollah.yamin.xmail.data.repo

import kotlinx.coroutines.flow.Flow
import mollah.yamin.xmail.data.models.UserAccount

interface UserAccountsRepository {
    fun getDefaultUserAccount(): Flow<UserAccount>
    fun getAllUserAccounts(): Flow<List<UserAccount>>
    fun getContactAccountByUid(uid: Long): Flow<UserAccount>
}