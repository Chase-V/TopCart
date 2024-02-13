package com.example.featurecamera

import androidx.lifecycle.ViewModel
import com.google.mlkit.vision.barcode.common.Barcode
import kotlinx.coroutines.flow.MutableStateFlow

class CameraViewModel : ViewModel() {

    var isBusy = MutableStateFlow(false)
    val barcodeData = MutableStateFlow("")

    fun handleBarcode(barcodes: List<Barcode>) {
        if (barcodes.isNotEmpty() and !isBusy.value) {
            if (barcodes.first().rawValue.toString().isNotEmpty()) {
                barcodeData.value = barcodes.first().rawValue.toString()
                isBusy.value = true
            }
        }
    }
}