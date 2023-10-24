package com.ggr3ml1n.retrofittest

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation

class SecondFragmentViewModel: ViewModel() {
    fun navigate(view: View) {
        Navigation.findNavController(view).navigate(R.id.navigateToFirst)
    }
}