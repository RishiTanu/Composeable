package com.example.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.democompose.theme.ComposeClass1Theme
import java.util.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeClass1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    val random by remember {
//        derivedStateOf {
//            Random(100).nextInt()
//        }
//    }

    ConstraintLayout(modifier) {
        val (t1, t2, t3, t4, t5, t6) = createRefs()
        Text(
            text = "Hello $name!", modifier = Modifier.constrainAs(t1) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            }, style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Hello $name!", modifier = Modifier
                .constrainAs(t2) {
                    end.linkTo(parent.end)
                    top.linkTo(parent.top)
                }
                .padding(5.dp)
                .border(1.dp, Color.Black, shape = RoundedCornerShape(12.dp))
                .padding(5.dp)
            , style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Rishi", modifier = Modifier
                .constrainAs(t6) {
                    end.linkTo(t3.start, 12.dp)
                    top.linkTo(t3.top)
                }
                .padding(5.dp)
                .border(2.dp, Color.Black, shape = RoundedCornerShape(3.dp)),
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Hello $name!", modifier = Modifier.constrainAs(t3) {
                centerTo(parent)
            }, style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Hello $name!", modifier = Modifier.constrainAs(t4) {
                start.linkTo(parent.start)
                bottom.linkTo(parent.bottom)
            }, style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Hello $name!", modifier = Modifier.constrainAs(t5) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }, style = MaterialTheme.typography.bodyMedium
        )
    }
}/*@Composable
fun Greeting(name: String,modifier:  Modifier = Modifier) {
    Box(modifier = Modifier.height(50.dp).width(500.dp)) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.wrapContentWidth(),
            style =  MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "2 Hello $name!",
            modifier = Modifier.wrapContentWidth().align(Alignment.BottomEnd),
            style =  MaterialTheme.typography.bodyLarge
        )
    }
}*/


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeClass1Theme {
        Greeting("Rishikesh", modifier = Modifier.fillMaxSize())
    }
}
