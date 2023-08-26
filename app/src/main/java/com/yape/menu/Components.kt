package com.yape.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun HeaderComponent(modifier: Modifier = Modifier, title: String) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
    ) {
        val (backButtonRef, titleRef, saveButtonRef) = createRefs()

        IconButton(
            onClick = { },
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .constrainAs(backButtonRef) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_arrow),
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.outline
            )
        }

        Text(
            text = title,
            style = MaterialTheme.typography.displayMedium,
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.constrainAs(titleRef) {
                linkTo(start = backButtonRef.end, end = saveButtonRef.start)
                linkTo(top = parent.top, bottom = parent.bottom)

            }
        )

        IconButton(
            onClick = { },
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.surface)
                .constrainAs(saveButtonRef) {
                    linkTo(top = parent.top, bottom = parent.bottom)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_bookmark),
                contentDescription = "Favorite",
                tint = MaterialTheme.colorScheme.outline
            )
        }

    }
}


@Preview
@Composable
fun HeaderComponentPreview() {
    MaterialTheme {
        HeaderComponent(title = "Details")
    }
}