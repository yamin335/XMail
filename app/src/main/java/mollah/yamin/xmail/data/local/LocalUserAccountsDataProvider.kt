package mollah.yamin.xmail.data.local

import mollah.yamin.xmail.R
import mollah.yamin.xmail.data.models.UserAccount

object LocalUserAccountsDataProvider {
    val allUserAccounts = listOf(
        UserAccount(
            id = 1L,
            uid = 0L,
            firstName = "Kiarki",
            lastName = "Shminge",
            email = "kiarki@gmail.com",
            altEmail = "kiarki@hotmail.com",
            avatar = R.drawable.ic_profile_avatar,
            isCurrentAccount = true
        ),
        UserAccount(
            id = 2L,
            uid = 0L,
            firstName = "Justin",
            lastName = "Benerd",
            email = "justin@gmail.com",
            altEmail = "justin@hub.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 3L,
            uid = 0L,
            firstName = "Christina",
            lastName = "Oliver",
            email = "christina@gmail.com",
            altEmail = "oliver@flink.com",
            avatar = R.drawable.ic_profile_avatar
        )
    )

    private val allUserContactAccounts = listOf(
        UserAccount(
            id = 4L,
            uid = 1L,
            firstName = "Trever",
            lastName = "Back",
            email = "trever@gmail.com",
            altEmail = "trever@hotmail.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 5L,
            uid = 2L,
            firstName = "Aljemin",
            lastName = "Takubo",
            email = "aljemin@gmail.com",
            altEmail = "aljemin@work.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 6L,
            uid = 3L,
            firstName = "Mia",
            lastName = "Jelifa",
            email = "mia@gmail.com",
            altEmail = "mia@android.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 7L,
            uid = 4L,
            firstName = "Robert",
            lastName = "Golang",
            email = "robert@gmail.com",
            altEmail = "robert@xmail.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 8L,
            uid = 5L,
            firstName = "Alan",
            lastName = "Walker",
            email = "alan@gmail.com",
            altEmail = "alan@tmail.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 9L,
            uid = 6L,
            firstName = "Free",
            lastName = "Man",
            email = "freeman@google.com",
            altEmail = "freeman@gmail.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 10L,
            uid = 7L,
            firstName = "Alex",
            lastName = "Brumer",
            email = "alex@gmail.com",
            altEmail = "alex@extrabold.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 11L,
            uid = 8L,
            firstName = "Tremon",
            lastName = "Traveler",
            email = "tremon@gmail.com",
            altEmail = "traveler@highway.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 12L,
            uid = 9L,
            firstName = "Sans",
            lastName = "Sheriff",
            email = "sans@gmail.com",
            altEmail = "sans@typecast.com",
            avatar = R.drawable.ic_profile_avatar
        ),
        UserAccount(
            id = 13L,
            uid = 10L,
            firstName = "John",
            lastName = "Moris",
            email = "moris@gmail.com",
            altEmail = "moris@thisisme.com",
            avatar = R.drawable.ic_profile_avatar
        )
    )

    /**
     * Get the current user's default account.
     */
    fun getDefaultUserAccount() = allUserAccounts.first()

    /**
     * Whether or not the given [Account.id] uid is an account owned by the current user.
     */
    fun isUserAccount(uid: Long): Boolean = allUserAccounts.any { it.uid == uid }

    /**
     * Get the contact of the current user with the given [accountId].
     */
    fun getContactAccountByUid(accountId: Long): UserAccount {
        return allUserContactAccounts.first { it.id == accountId }
    }
}