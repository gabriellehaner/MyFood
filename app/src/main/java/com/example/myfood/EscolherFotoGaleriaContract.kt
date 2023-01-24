package com.example.myfood

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContract

class EscolherFotoGaleriaContract : ActivityResultContract<Int, Uri?>() {

    override fun createIntent(context: Context, input: Int): Intent {
        return Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Uri? {
        return intent?.data
    }
}
