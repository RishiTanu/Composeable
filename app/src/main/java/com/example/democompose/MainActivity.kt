package com.example.democompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.democompose.theme.ComposeClass1Theme
import com.example.democompose.ui.Greeting
import com.example.democompose.ui.UserInteraction

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeClass1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android", modifier = Modifier.fillMaxSize())
                    UserInteraction(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeClass1Theme {
        Greeting("Rishikesh", modifier = Modifier.fillMaxSize())
    }
}
