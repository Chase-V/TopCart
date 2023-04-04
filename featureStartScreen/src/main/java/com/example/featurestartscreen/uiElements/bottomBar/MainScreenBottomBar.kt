package com.example.featurestartscreen.uiElements.bottomBar

import android.view.Gravity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider

//Todo конь не валялся, просто заглушка

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MainScreenBottomBar(
    onNavigateToAddProduct: () -> Unit,
    onNavigateToAddCategory: () -> Unit,
    onBackIconPressed:() -> Unit,
    modifier: Modifier = Modifier
) {

    var isAddPressed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 48.dp, max = 48.dp)
            .padding(horizontal = 24.dp)
    ) {

        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = null,
            modifier = modifier
                .align(
                Alignment.CenterStart
            ).clickable(onClick = onBackIconPressed)
        )

        if (isAddPressed) {
            Dialog(
                onDismissRequest = { isAddPressed = !isAddPressed },
                properties = DialogProperties(usePlatformDefaultWidth = false)
            ) {
                val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
                dialogWindowProvider.window.setGravity(Gravity.BOTTOM)

                Box(
                    modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(
                            RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)
                        )
                        .background(MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxSize()
                    ) {

                        ElevatedButton(onClick = onNavigateToAddCategory) {
                            Text(text = "Category")
                        }

                        Spacer(modifier = Modifier.width(64.dp))

                        ElevatedButton(
                            onClick = onNavigateToAddProduct
                        ) {
                            Text(text = "Product")
                        }
                    }
                }

            }
        }

        AnimatedVisibility(
            visible = !isAddPressed,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-24).dp),
            enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 })
        ) {
            ElevatedButton(
                onClick = { isAddPressed = !isAddPressed },
                modifier = modifier
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = null)
            }
        }

        AnimatedVisibility(
            visible = isAddPressed,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = (-24).dp),
            enter = fadeIn() + slideInVertically(initialOffsetY = { it / 2 }),
            exit = fadeOut() + slideOutVertically(targetOffsetY = { it / 2 })
        ) {


        }


        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = null,
            modifier = modifier.align(
                Alignment.CenterEnd
            )
        )
    }

}
