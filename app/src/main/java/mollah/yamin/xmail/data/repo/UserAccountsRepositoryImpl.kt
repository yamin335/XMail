package mollah.yamin.xmail.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mollah.yamin.xmail.data.local.LocalUserAccountsDataProvider
import mollah.yamin.xmail.data.models.UserAccount

class UserAccountsRepositoryImpl : UserAccountsRepository {

    override fun getDefaultUserAccount(): Flow<UserAccount> = flow {
        emit(LocalUserAccountsDataProvider.getDefaultUserAccount())
    }

    override fun getAllUserAccounts(): Flow<List<UserAccount>> = flow {
        emit(LocalUserAccountsDataProvider.allUserAccounts)
    }

    override fun getContactAccountByUid(uid: Long): Flow<UserAccount> = flow {
        emit(LocalUserAccountsDataProvider.getContactAccountByUid(uid))
    }
}