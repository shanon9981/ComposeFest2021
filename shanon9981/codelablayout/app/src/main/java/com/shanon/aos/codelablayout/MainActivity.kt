package com.shanon.aos.codelablayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.shanon.aos.codelablayout.ui.theme.CodelablayoutTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodelablayoutTheme {
                LayoutsCodelab()
            }
        }
    }
}
@Composable
fun LayoutsCodelab() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "LayoutsCodelab")
                },
                actions = {
                    IconButton(onClick = { /* doSomething() */ }) {
                        Icon(Icons.Filled.Favorite, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        BodyContent(Modifier.padding(innerPadding))
    }
}

@Composable
fun BodyContent(modifier: Modifier = Modifier) {
    ScrollingList()
//    SimpleList()
//    ImageList()
//    Column(modifier = modifier.padding(8.dp)) {
//        Text(text = "Hi there!")
//        Text(text = "Thanks for going through the Layouts codelab")
//    }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
    CodelablayoutTheme {
        LayoutsCodelab()
    }
}


@Composable
fun PhotographerCard() {
    Column {
        Text("Alfred Sisley", fontWeight = FontWeight.Bold)
        // LocalContentAlpha is defining opacity level of its children
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text("3 minutes ago", style = MaterialTheme.typography.body2)
        }



//        Button(text = "hello") {
//
//        }
//
//        Button(
//            onClick = { /*TODO*/ },
//        modifier = Modifier.padding(10.dp),
//        icon: Icon? = myIcon,
//        textst) {
//
//        }
//        Button(text = "Button")
//        Button(
//            text = "Button",
//            icon: Icon? = myIcon,
//        textStyle = TextStyle(...),
//        spacingBetweenIconAndText = 4.dp
//        )

    }
}

@Preview
@Composable
fun PhotographerCardPreview() {
    CodelablayoutTheme {
        PhotographerCard()
    }
}

@Composable
fun SimpleList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberScrollState()

    Column(Modifier.verticalScroll(scrollState)) {
        repeat(100) {
            Text("Item #$it")
        }
    }
}

@Composable
fun LazyList() {
    // We save the scrolling position with this state that can also
    // be used to programmatically scroll the list
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            Text("Item #$it")
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {

        Image(
            painter = rememberImagePainter(
                data = "https://developer.android.com/images/brand/Android_Robot.png"
            ),
            contentDescription = "Android Logo",
            modifier = Modifier.size(50.dp)
        )
        Spacer(Modifier.width(10.dp))
        Text("Item #$index", style = MaterialTheme.typography.subtitle1)
    }
}

@Composable
fun ImageList() {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState) {
        items(100) {
            ImageListItem(it)
        }
    }
}


@Composable
fun ScrollingList() {
    val listSize = 100
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()
    // We save the coroutine scope where our animated scroll will be executed
    val coroutineScope = rememberCoroutineScope()

    Column {
        Row {
            Button(onClick = {
                coroutineScope.launch {
                    // 0 is the first item index
                    scrollState.animateScrollToItem(0)
                }
            }) {
                Text("Scroll to the top")
            }

            Button(onClick = {
                coroutineScope.launch {
                    // listSize - 1 is the last index of the list
                    scrollState.animateScrollToItem(listSize - 1)
                }
            }) {
                Text("Scroll to the end")
            }
        }

        LazyColumn(state = scrollState) {
            items(listSize) {
                ImageListItem(it)
            }
        }
    }
}
//
//fun Modifier.firstBaselineToTop(
//    firstBaselineToTop: Dp
//) = this.then(
//    layout { measurable, constraints ->
//        // Height of the composable with padding - first baseline
//        val placeableY = firstBaselineToTop.roundToPx() - firstBaseline
//        val height = placeable.height + placeableY
//        layout(placeable.width, height) {
//            // Where the composable gets placed
//            placeable.placeRelative(0, placeableY)
//        }
//    }
//)

//
//@Preview
//@Composable
//fun TextWithPaddingToBaselinePreview() {
//    CodelablayoutTheme {
//        Text("Hi there!", Modifier.firstBaselineToTop(32.dp))
//    }
//}
//
//@Preview
//@Composable
//fun TextWithNormalPaddingPreview() {
//    CodelablayoutTheme {
//        Text("Hi there!", Modifier.padding(top = 32.dp))
//    }
//}
