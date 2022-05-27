package com.example.nativecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.nativecompose.ui.theme.NativeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NativeComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MessageFromNativeLibrary(stringFromJNI())
                }
            }
        }
    }

    external fun stringFromJNI(): String

    companion object {
        init {
            System.loadLibrary("nativecompose")
        }
    }

}

@Composable
fun MessageFromNativeLibrary(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NativeComposeTheme {
        MessageFromNativeLibrary("Android")
    }
}
