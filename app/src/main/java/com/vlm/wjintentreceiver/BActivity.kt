package com.vlm.wjintentreceiver

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.vlm.wjintentreceiver.ui.theme.WJIntentReceiverTheme

class BActivity : ComponentActivity() {

    //https://medium.com/androiddevelopers/all-about-pendingintents-748c8eb8619
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
                        val int = intent?.extras?.get("Intent")
                        int?.let{
                            val pi = try {
                                it as PendingIntent
                            }catch (e:Exception){
                                it as Intent
                            }

                            Button(onClick = {
                                try {
                                    (pi as PendingIntent).send()
                                }catch (e:java.lang.Exception){
                                    startActivity(pi as Intent)
                                }
                            }) {

                            }
                        }

                    }else{
                        Greeting("내가 그 기능 할게")
                    }
                }
            }
        }
    }
}
