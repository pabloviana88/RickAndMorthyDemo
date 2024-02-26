package com.nels.master.rickandmortydemo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import com.nels.master.rickandmortydemo.domian.models.Result


@Composable
fun Item(result: Result) {

    var show by rememberSaveable {
        mutableStateOf(false)
    }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier.weight(1f).clip(shape = ShapeDefaults.ExtraLarge),
                model = result.image,
                contentDescription = null,
            )

            Text(
                text = result.name, maxLines = 2, overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(1f) ,

                )

            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    show = !show
                }) {
                if (show)
                    Text(text = "Ocultar")
                else
                    Text(text = "Mostrar")
            }

        }

        if (show)
            ExpandDetail(result)
    }


}

@Composable
fun ExpandDetail(result: Result) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Nombre: ${result.name}")
        Text(text = "Genero: ${result.gender}")
        Text(text = "Tipo: ${result.type}")
        Text(text = "Estatus: ${result.status}")
    }
}



