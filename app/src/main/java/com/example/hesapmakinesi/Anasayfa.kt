package com.example.hesapmakinesi

import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Anasayfa() {
    val configuration = LocalConfiguration.current
    val genislik = configuration.screenWidthDp
    val yukseklik = configuration.screenHeightDp
    //Log.e("test","$genislik-$yukseklik") //411-707
    val kG = 0.12165 * genislik
    val kY = 0.07072 * yukseklik

    var ekran = remember {
        mutableStateOf("")
    }



    Scaffold(


    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {

            Box(modifier = Modifier.size((kG*8.1).dp,100.dp).background(color = Color.Red).padding(10.dp).align(Alignment.End)) {
                Text(text = ekran.value, color = Color.White, modifier = Modifier
                    .fillMaxWidth() // Ensure the Text takes the full width of the Box
                    .align(Alignment.CenterEnd))
            }


            Row(
                horizontalArrangement = Arrangement.Start,


                ) {
                Column() {

                    Row {
                        ButtonChip(icerik = "9", h = (kY * 2).toInt(), (kG * 2).toInt()) {
                            ekran.value += "9"
                        }
                        ButtonChip(icerik = "8", (kY * 2).toInt(), (kG * 2).toInt()) {
                            ekran.value += "8"
                        }
                        ButtonChip(icerik = "7", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "7"
                        }
                    }
                    Row {
                        ButtonChip(icerik = "6", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "6"
                        }
                        ButtonChip(icerik = "5", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "5"
                        }
                        ButtonChip(icerik = "4", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "4"
                        }
                    }
                    Row {
                        ButtonChip(icerik = "3", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "3"
                        }
                        ButtonChip(icerik = "2", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "2"
                        }
                        ButtonChip(icerik = "1", (kY * 2).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += "1"
                        }
                    }
                    Row {
                        ButtonChip(icerik = "0", (kY * 2).toInt(), (kG * 4.02).toInt())
                        {
                            ekran.value += "0"
                        }
                        ButtonChip(icerik = ",", ((kY * 2)).toInt(), (kG * 2).toInt())
                        {
                            ekran.value += ","
                        }

                    }
                }
                Column() {
                    ButtonChip(icerik = "Sil", ((kY * 2)).toInt(), (kG * 2).toInt())
                    {

                    }
                    ButtonChip(icerik = "+", ((kY * 2)).toInt(), (kG * 2).toInt())
                    {
                        ekran.value += "+"
                    }
                    ButtonChip(icerik = "=", ((kY * 4.02)).toInt(), (kG * 2).toInt())
                    {

                    }
                }


            }


        }


    }


}