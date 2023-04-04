package com.example.coreui.elements

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
    FilledIconButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(11.dp),
        colors = IconButtonDefaults.iconButtonColors(MaterialTheme.colorScheme.primaryContainer)
    ) {
        Icon(
            painterResource(id = iconResId),
            contentDescription = stringResource(R.string.open_barcode_scanner_button),
            modifier = Modifier.padding(6.dp),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}