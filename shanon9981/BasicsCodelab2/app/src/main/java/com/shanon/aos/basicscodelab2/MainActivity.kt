package com.shanon.aos.basicscodelab2

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shanon.aos.basicscodelab2.ui.theme.BasicsCodelab2Theme

import androidx.compose.foundation.lazy.items

import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelab2Theme {
//                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
//                }
                MyApp()
            }
        }
    }


}

@Composable
private fun MyApp() {
    var shouldShowOnborading by rememberSaveable { mutableStateOf( true ) }

    if(shouldShowOnborading) {
        OnboardingScreen(onContinueClicked = { shouldShowOnborading = false})
    } else {
        Greetings()
    }

}

@Composable
private fun OnboardingScreen(onContinueClicked: () -> Unit) {
    Surface() {
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text( "안녕하세요 기초 코드랩 입니다.")
            Button(
                modifier = Modifier.padding(vertical = 24.dp),
                onClick = onContinueClicked
            ){
                Text(text = "계속 하기")
            }
        }
    }

}

@Composable
private fun Greetings(names: List<String> = List(30) {"$it"} ) {
    LazyColumn(
        modifier = Modifier.padding(vertical = 4.dp)
    ) {
        items(items = names) { name ->
            Greeting( name = name)
        }
    }
}

@Composable
private fun Greeting(name: String){
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        CardContent(name)
    }
}

@Composable
fun CardContent(name: String) {
    var expanded by remember {
        mutableStateOf (false)
    }

    Row(
        modifier = Modifier
            .padding(12.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
    ) {
       Column (
           modifier = Modifier
               .weight(1f)
               .padding(12.dp)
       ){
           Text("Hello")
           Text(
               text = name,
               style = MaterialTheme.typography.h4.copy(
                   fontWeight = FontWeight.ExtraBold
               )
           )
           if(expanded) {
               Text(
                   text = ("Composem ipsum color sit lazy, " +
                           "padding theme elit, sed do bouncy. ").repeat(4)
               )
           }
       }
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                imageVector = if(expanded)  Filled.ExpandLess else Filled.ExpandMore,
                contentDescription = if(expanded) {
                    stringResource(R.string.show_less)
                } else {
                    stringResource(R.string.show_more)
                })
        }

    }

}

@Preview(
    showBackground = true,
    widthDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DefaultPreviewDark"
)
@Preview(showBackground = true, widthDp = 320)
@Composable
fun DefaultPreview() {
    BasicsCodelab2Theme {
        Greetings()
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelab2Theme {
        OnboardingScreen(onContinueClicked = {})
    }
}