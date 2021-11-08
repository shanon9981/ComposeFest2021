package com.shanon.aos.layoutcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shanon.aos.layoutcompose.ui.theme.LayoutComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainCodelabPreview()
                }
            }
        }
    }
}


@Preview
@Composable
fun MainCodelabPreview() {
    LayoutComposeTheme {
        LayoutsCodelab()
    }
}


//
//@Composable
//fun LayoutsCodelab() {
////    Text(text = "Hi sdfsdfsdfsdfs!")
////    Scaffold { innerPadding ->
////        Column(modifier = Modifier.padding(innerPadding)) {
////            Text(text = "Hi there!")
////            Text(text = "Thanks for going through the Layouts codelab")
////        }
////    }
//
//    Scaffold(
//        topBar = {
//            TopAppBar(
//                title = {
//                    Text(text = "LayoutsCodelab")
//                },
//                actions = {
//                    IconButton(onClick = { /* doSomething() */ }) {
//                        Icon(Icons.Filled.Favorite, contentDescription = null)
//                    }
//                }
//            )
//        }
//    ) { innerPadding ->
//        BodyContent(Modifier.padding(innerPadding))
//    }
//}

//@Composable
//fun BodyContent(modifier: Modifier = Modifier) {
//    Column(modifier = modifier){
//        PhotographerCard()
//        Column(modifier = modifier) {
//            Text(text = "Hi there!")
//            Text(text = "Thanks for going through the Layouts codelab")
//        }
//        Column(modifier = modifier
//            .padding(vertical = 20.dp)) {
//            Text(text = "Hi---------------------there!-----------------------------")
//            Text(text = "Thanks for g------------------oing through the Layouts codelab")
//        }
//        ScrollingList()
//
//    }
//}
//
//@Preview
//@Composable
//fun LayoutsCodelabPreview() {
//    LayoutComposeTheme {
//        LayoutsCodelab()
//    }
//}
