package com.example.featurestartscreen.uiElements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.coremodel.entities.Product
import com.example.featurestartscreen.R
import eu.wewox.textflow.TextFlow
import eu.wewox.textflow.TextFlowObstacleAlignment

@Composable
fun ProductCard(
    modifier: Modifier = Modifier,
    product: Product
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
            .heightIn(max = 200.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Row {
            if (!product.photoURI.isNullOrEmpty()) {
                AsyncImage(
                    model = product.photoURI,
                    contentDescription = null,
                    modifier = modifier
                        .width(150.dp)
                        .fillMaxHeight(),
                    alignment = Alignment.CenterStart,
                    contentScale = ContentScale.Crop,
                )
            }
            Column(modifier.padding(14.dp)) {
                TitleAndRatingRow(title = product.title, rating = product.rating)
                Text(
                    text = product.comment,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = modifier.padding(top = 8.dp),
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }

    }
}

@Composable
fun TitleAndRatingRow(modifier: Modifier = Modifier, title: String, rating: Int) {

    TextFlow(
        text = title,
        modifier = modifier
            .fillMaxWidth(),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        obstacleAlignment = TextFlowObstacleAlignment.TopEnd,
        obstacleContent = {
            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = modifier
                    .widthIn(min = 32.dp)
                    .padding(start = 4.dp)

            ) {
                Icon(
                    imageVector = Icons.Rounded.Star,
                    contentDescription = stringResource(R.string.rating),
                    tint = Color(0xFFEFCE4A)
                )
                Text(text = rating.toString())
            }
        }
    )
}