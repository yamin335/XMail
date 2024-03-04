package mollah.yamin.xmail.data.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import mollah.yamin.xmail.data.local.LocalEmailsDataProvider
import mollah.yamin.xmail.data.models.Email
import mollah.yamin.xmail.data.models.MailboxType

class EmailsRepositoryImpl : EmailsRepository {
    override fun getAllEmails(): Flow<List<Email>> = flow {
        emit(LocalEmailsDataProvider.allEmails)
    }

    override fun getCategoryEmails(category: MailboxType): Flow<List<Email>> = flow {
        val categoryEmails = LocalEmailsDataProvider.allEmails.filter { it.mailbox == category }
        emit(categoryEmails)
    }

    override fun getAllFolders(): List<String> {
        return LocalEmailsDataProvider.getAllFolders()
    }

    override fun getEmailFromId(id: Long): Flow<Email?> = flow {
        val categoryEmails = LocalEmailsDataProvider.allEmails.firstOrNull { it.id == id }
    }
}
