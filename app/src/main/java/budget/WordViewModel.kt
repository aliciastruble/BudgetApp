package budget

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: WordRepository = WordRepository(application)
    private val allWords: LiveData<List<Transaction>> = mRepository.allWords

    fun getAllWords(): LiveData<List<Transaction>> {
        return allWords
    }

    fun insert(transaction: Transaction) {
        mRepository.insert(transaction)
    }
}