package com.example.coreui.elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.coreui.R

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    @DrawableRes iconResId: Int,
    onClick:() -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.height(54.dp),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(14.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Icon(
            painterResource(id = iconResId),
            contentDescription = stringResource(R.string.open_barcode_scanner_button),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}