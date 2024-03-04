package mollah.yamin.xmail.data.repo

import kotlinx.coroutines.flow.Flow
import mollah.yamin.xmail.data.models.Email
import mollah.yamin.xmail.data.models.MailboxType

interface EmailsRepository {
    fun getAllEmails(): Flow<List<Email>>
    fun getCategoryEmails(category: MailboxType): Flow<List<Email>>
    fun getAllFolders(): List<String>
    fun getEmailFromId(id: Long): Flow<Email?>
}
