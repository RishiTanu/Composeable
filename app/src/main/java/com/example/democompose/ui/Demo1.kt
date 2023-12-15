package com.example.democompose.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

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
                .padding(5.dp), style = MaterialTheme.typography.bodyMedium
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
}
/*@Composable
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