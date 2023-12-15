package com.example.democompose.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.democompose.R
import com.example.democompose.theme.ComposeClass1Theme

@Composable
fun UserInteraction(
    modifier: Modifier = Modifier
) {
    var count by remember {
        mutableIntStateOf(0)
    }
    /*var text = remember {
        mutableStateOf("")
    }*/
    var text by remember {
        mutableStateOf("")
    }

    var items by remember {
        mutableStateOf(listOf<String>())
    }

    val context = LocalContext.current
    Box(modifier = modifier) {
        Text(
            "Count $count",
            modifier = Modifier.align(Alignment.TopStart)
        )
        TextFieldDemo(
            textState = text,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .width(250.dp),
            onTextChangeListener = {
                text = it
            }
        )
        Button(
            onClick = {
                count++
                Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
                items = items + text
                text = ""
            },
            modifier = Modifier.align(Alignment.Center)
        ) {
            Icon(
                painter = painterResource(androidx.core.R.drawable.ic_call_answer),
                contentDescription = "",
               // tint = Color.Unspecified
            )
            Image(
                painter = painterResource(R.drawable.ic_camera),
                contentDescription = "",
                modifier=Modifier.clip(CircleShape)
            )
            Text("CLick Me")
        }
        ListViewDemo(
            items,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Composable
fun TextFieldDemo(
    textState: String,
    modifier: Modifier = Modifier,
    onTextChangeListener: (String) -> Unit = {

    }
) {
    OutlinedTextField(
        value = textState,
        modifier = modifier,
        onValueChange = onTextChangeListener
    )
}

@Composable
fun ListViewDemo(listOfString: List<String>, modifier: Modifier = Modifier) {
    /*Column {
        listOfString.forEach {
            Text(text = it)
        }
    }*/
    LazyColumn(modifier) {
        /*items(listOfString){
            Text(it)
        }*/
        itemsIndexed(listOfString) { _, item ->
            Text(item)
        }
    }
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {

    }
}

@Preview(showBackground = true)
@Composable
fun ListViewDemoPreview() {
    ComposeClass1Theme {
        ListViewDemo(
            listOfString = listOf(
                "Rishi",
                "Bhuvi",
                "Kartik",
                "Abram"
            ),
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun UserInteractionPreview() {
    ComposeClass1Theme {
        UserInteraction(modifier = Modifier.fillMaxSize())
    }
}
