package com.sample.tmdb.common.ui

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.ui.text.intl.Locale
import androidx.core.os.LocaleListCompat
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

@HiltViewModel
class LanguageViewModel @Inject constructor() : ViewModel() {

    private val _languageCode = MutableStateFlow(Locale.current.language)
    val languageCode: StateFlow<String> = _languageCode.asStateFlow()

    fun setLanguage(code: String) {
        _languageCode.value = code
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(code))
    }
}
