package com.game.ticketmaster.app.ui

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ViewAgenda
import androidx.compose.material.icons.filled.Window
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.game.ticketmaster.app.data.model.Events
import com.game.ticketmaster.app.ui.model.HomeViewModel
import com.game.ticketmaster.ui.theme.CyanTeal
import com.game.ticketmaster.ui.theme.Teal200
import com.game.ticketmaster.ui.theme.Teal900
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HomeScreen(navController: NavController, homeViewModel: HomeViewModel) {
    var selectedText = homeViewModel.selectedText.value
    val events by homeViewModel.events.observeAsState(emptyList())

    var isHomeIcon by remember { mutableStateOf(true) }
    //val events by homeViewModel.events.observeAsState(emptyList())
    //val events by homeViewModel.getEventsByCity(selectedText!!).observeAsState(emptyList())

    Column() {
        Row() {
            MyDropDownMenu(homeViewModel, selectedText)
            Icon(
                modifier = Modifier
                    .padding(top = 16.dp, start = 8.dp, end = 8.dp)
                    .clickable {
                        isHomeIcon = !isHomeIcon
                        homeViewModel.changeGrid()
                    }
                    .align(Alignment.CenterVertically),
                imageVector = if (isHomeIcon) Icons.Default.Window else Icons.Default.ViewAgenda,
                contentDescription = "",
                tint = Teal200)

        }

        Spacer(modifier = Modifier.height(8.dp))
        Mygrid(homeViewModel = homeViewModel, selectedText!!, events)
    }
}


@Composable
fun ItemEvent(event: Events, function: () -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .clickable {
                isExpanded = !isExpanded
                Log.d("IS EXPANDED", isExpanded.toString())
            }
            .padding(8.dp)
    ) {
        event.images?.let {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(event.images.first().url),
                    contentDescription = "Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
        Column(
            Modifier
                .background(Teal200)
                .padding(8.dp)) {
            event.name?.let { Text(text = it, lineHeight = 15.sp, modifier =  Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold, color = Teal900, fontSize = 14.sp)}
            val formattedDate = formatDate(event.dates.start?.localDate ?: "")
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = formattedDate, Modifier.fillMaxWidth(), color = Teal900, fontSize = 12.sp)
            if (isExpanded) {
                event.venues?.address?.line1?.let { Text(text = "address: " + it) }
                Text(text = "popop")
                Text(text = "popop")
            }
        }
    }
}


fun formatDate(inputDate: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d 'de' MMMM yyyy", Locale.getDefault())
    val date: Date = inputFormat.parse(inputDate) ?: return ""
    return outputFormat.format(date)
}

@Composable
fun Mygrid(homeViewModel: HomeViewModel, selectedText: String, events: List<Events>?) {
    val context = LocalContext.current
    val myList = listOf("pepe", "manuel", "gloria")
    val gridDesignValue by homeViewModel.gridDesign.observeAsState(initial = 1)
    LazyVerticalGrid(columns = GridCells.Fixed(gridDesignValue)) {
        events?.let { eventList ->

            items(eventList) { event ->

                ItemEvent(event = event) {
                }
            }
        }
    }

}

@Composable
fun MyAlertDialog(event: Events, onClose: () -> Unit) {
    AlertDialog(
        onDismissRequest = onClose,
        title = { Text(text = event.name, fontWeight = FontWeight.Bold) },
        text = {
            Column {
                Text(text = event.name)
                Text(text = event.Links.toString())
                // Otros detalles del evento
            }
        },
        confirmButton = {},
        dismissButton = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu(homeViewModel: HomeViewModel, selectedText: String?) {
    val ciudades = homeViewModel.ciudades
    val setSelectedText: (String) -> Unit = { newValue ->
        homeViewModel.selectedText.value = newValue
    }
    val context = LocalContext.current
    var expanded by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            //.fillMaxWidth()
            .padding(top = 16.dp, start = 8.dp, end = 8.dp)
        //.wrapContentSize(Alignment.Center)
    ) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedText!!,
                onValueChange = {},
                textStyle = TextStyle(fontWeight = FontWeight.Bold),
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor(),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Teal200,
                    textColor = Teal900,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                ciudades.value?.forEach { ciudad ->
                    DropdownMenuItem(
                        modifier = Modifier
                            .background(CyanTeal)
                            .padding(0.dp)
                            .wrapContentHeight(),
                        text = {
                            Text(
                                text = ciudad,
                                fontWeight = FontWeight.Bold,
                                color = Teal900
                            )
                        },
                        onClick = {
                            setSelectedText(ciudad)
                            homeViewModel.getEventsByCity(ciudad)
                            expanded = false
                            Toast.makeText(context, ciudad, Toast.LENGTH_SHORT).show()
                        })
                }
            }
        }
    }
}

