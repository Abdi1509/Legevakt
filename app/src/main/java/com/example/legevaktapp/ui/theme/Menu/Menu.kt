package com.example.legevaktapp.ui.theme.Menu

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.legevaktapp.R


@Composable
fun Meny(navController: NavController) {
    val RegularFont = FontFamily(Font(R.font.kregular))

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start) {
                        Image(
                            painter = painterResource(id = R.drawable.profiltest),
                            contentDescription = "Logo",
                            modifier = Modifier.size(80.dp)
                        )
                        Text(
                            "Hei Mattias!",
                            fontSize = 40.sp,
                            color = Color.Black,
                            style = TextStyle(fontFamily = RegularFont)
                        )
                    }
                    HorizontalSwipeableContent()
                    Activity(navController = navController)

                }
            }
        }

        Bluepart(navController)
    }
}


@Composable
fun Bluepart(navController: NavController) {
    val RegularFont = FontFamily(Font(R.font.kregular))

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.1f)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color(0xFF005A9B)),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                BookButton(navController = navController)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalSwipeableContent() {
    val pageCount = 3 // Number of swipeable pages
    val pagerState = rememberPagerState(pageCount = { pageCount })
    val coroutineScope = rememberCoroutineScope()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Page ${page + 1}",
                        fontSize = 24.sp,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dots Indicator
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(pageCount) { index ->
                val color = if (pagerState.currentPage == index) Color(0xFF005A9B) else Color.Gray
                Box(
                    modifier = Modifier
                        .size(22.dp)
                        .padding(4.dp)
                        .background(color, shape = CircleShape)
                )
            }
        }
    }
}

@Composable
fun Activity(navController: NavController){
    val RegularFont = FontFamily(Font(R.font.kregular))

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = "Hva vil du gjøre idag?",
            style = TextStyle(
                fontFamily = RegularFont,
                fontSize = 40.sp,
                color = Color.Black
            ),
            modifier = Modifier.padding(8.dp)
        )

        // Creating a 2x2 grid of clickable boxes
        Column {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ClickableBox(navController, "Activity 1", Color(0xFFFFC107))
                ClickableBox(navController, "Activity 2", Color(0xFF8BC34A))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ClickableBox(navController, "Activity 3", Color(0xFF03A9F4))
                ClickableBox(navController, "Activity 4", Color(0xFFE91E63))
            }
        }
    }
}

@Composable
fun ClickableBox(navController: NavController, text: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable {
                // Handle click event
                navController.navigate("some_route")
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 20.sp,
            fontFamily = FontFamily(Font(R.font.kregular))
        )
    }
}

@Composable
fun BookButton(navController: NavController) {
    val RegularFont = FontFamily(Font(R.font.kregular))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(60.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { navController.navigate("Meny") },
            colors = ButtonDefaults.buttonColors(Color(0xFFFFFFFF)),
            modifier = Modifier
                .width(195.dp)
                .height(60.dp)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                "Book Time",
                color = Color.Black,
                fontSize = 20.sp,
                style = TextStyle(fontFamily = RegularFont)
            )
        }
    }
}

