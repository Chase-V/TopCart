package com.example.featurecamera

import android.util.Log
import androidx.camera.core.ExperimentalGetImage
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.google.mlkit.vision.barcode.BarcodeScannerOptions
import com.google.mlkit.vision.barcode.BarcodeScanning
import com.google.mlkit.vision.common.InputImage

@ExperimentalGetImage
class BarcodeAnalyzer(
    private val viewModel: CameraViewModel
) : ImageAnalysis.Analyzer {

    override fun analyze(imageProxy: ImageProxy) {

        val options = BarcodeScannerOptions
            .Builder()
            .enableAllPotentialBarcodes()
            .build()

        val scanner = BarcodeScanning.getClient(options)
        val mediaImage = imageProxy.image
        mediaImage?.let {
            val image =
                InputImage.fromMediaImage(mediaImage, imageProxy.imageInfo.rotationDegrees)
            scanner.process(image)
                .addOnSuccessListener { barcodes ->
                    viewModel.handleBarcode(barcodes)
                }
                .addOnFailureListener { exception ->
                    Log.d(
                        "MyLog",
                        "Barcode Analyzer ERROR: analyze: ${exception.message.toString()}"
                    )
                }
                .addOnCompleteListener {
                    imageProxy.close()
                }
        }
    }


}