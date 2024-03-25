package com.example.explorewise.presentation.common

import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.explorewise.R
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.delay


@Composable
fun AutoSlidingCarousel(
    modifier: Modifier = Modifier,
    autoSlideDuration: Long = 5000,
    pagerState: PagerState = remember { PagerState() },
    itemsCount: Int,
    itemContent: @Composable (index: Int) -> Unit,
) {
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    LaunchedEffect(pagerState.currentPage) {
        delay(autoSlideDuration)
        pagerState.animateScrollToPage((pagerState.currentPage + 1) % itemsCount)
    }

    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        HorizontalPager(count = itemsCount, state = pagerState) { page ->
            itemContent(page)
        }

        // you can remove the surface in case you don't want
        // the transparent background
//        Surface(
//            modifier = Modifier
//                .padding(bottom = 8.dp)
//                .align(Alignment.BottomCenter),
//            shape = CircleShape,
//            color = Color.Black.copy(alpha = 0.5f)
//        ) {
//
//        }
    }
}

@Preview
@Composable
fun AutoSlidePreview() {
    val images = listOf(
        R.drawable.carousel5,
        R.drawable.carousel7,
        R.drawable.carousel8,
        R.drawable.carousel6
    )
    Card(
        modifier = Modifier
            .padding(24.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        AutoSlidingCarousel(
            itemsCount = images.size,
            itemContent = { index ->

                val imageModifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(16f / 9f)

                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(images[index])
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = imageModifier
                )
            }
        )
    }
}