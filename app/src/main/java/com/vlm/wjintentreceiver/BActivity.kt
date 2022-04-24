package com.vlm.wjintentreceiver

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.vlm.wjintentreceiver.ui.theme.WJIntentReceiverTheme

class BActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WJIntentReceiverTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if(intent != null){
                        Greeting(intent?.extras?.getString("MY_NAME") ?: "이름 모름")
                    }else{
                        Greeting("내가 그 기능 할게")
                    }
                }
            }
        }
    }
}
