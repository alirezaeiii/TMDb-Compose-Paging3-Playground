package com.sample.tmdb.common.repository

import androidx.compose.ui.text.intl.Locale
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@Singleton
class LanguageRepository @Inject constructor() {

    private val _languageCode = MutableStateFlow(Locale.current.language)
    val languageCode: StateFlow<String> = _languageCode.asStateFlow()

    fun setLanguage(code: String) {
        _languageCode.value = code
    }
}
