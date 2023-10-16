package com.damjms.lazycolumnycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.damjms.lazycolumnycard.data.Pelicula
import com.damjms.lazycolumnycard.data.lista
import com.damjms.lazycolumnycard.ui.theme.Blue
import com.damjms.lazycolumnycard.ui.theme.LightBlue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumn(
                modifier = Modifier
                    .background(LightBlue)
            ) {
                items(lista) { peli ->
                    Greeting(pelicula = peli)
                }
            }
        }
    }
}

@Composable
fun Greeting(pelicula: Pelicula) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .padding(15.dp)
    ) {
        Text(
            text = pelicula.nombre,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Blue)
                .padding(16.dp)
                .fillMaxWidth()
        )
        Row {
            Image(
                modifier = Modifier
                    .size(200.dp)
                    .padding(start = 16.dp),
                painter = painterResource(id = pelicula.imagen),
                contentDescription = "poster pelicula: ${pelicula.nombre}",
                alignment = Alignment.Center
            )
            Column {
                Text(
                    text = "Director: ${pelicula.director}",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                )
                Text(
                    text = "Año de estreno: ${pelicula.año}",
                    fontSize = 15.sp,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
        }
    }
}
