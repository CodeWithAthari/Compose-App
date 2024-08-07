package com.crashcourse.compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.crashcourse.compose.ui.theme.ComposeAppTheme

val listItems = mutableListOf(0)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            repeat(100) {
                listItems.add(it)
            }
            ComposeAppTheme {
                Scaffold { innerPaddings ->
                    Column(
                        modifier = Modifier
                            .padding(innerPaddings)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MainApp(Modifier)
                    }


                }
            }
        }
    }


}


@SuppressLint("UnrememberedMutableState")
@Composable
private fun MainApp(modifier: Modifier) {
    LazyColumn (
        modifier = modifier
    ){
        items(100){
            VideoItem(
                modifier = Modifier
            )
        }
    }
}

@Composable
fun VideoItem(modifier: Modifier = Modifier,) {
    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Image(
            modifier = Modifier.clip(RoundedCornerShape(12.dp)),
            painter = painterResource(id = R.drawable.final_normal),
            contentDescription = null
        )
        Text(
            text = "Video Player App in Compose | Dev Atrii",
            modifier = Modifier.padding(vertical = 8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(18f, TextUnitType.Sp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "2.1k views")
            Box(
                modifier = Modifier
                    .padding(horizontal = 4.dp)
                    .alpha(0.5f)
                    .clip(CircleShape)
                    .background(Color.Gray)
                    .size(10.dp)
            )
            Text(text = "2 weeks ago")
        }
    }
}


@Composable
fun LazyHorizontalGridExample(modifier: Modifier = Modifier) {
    LazyHorizontalGrid(rows = GridCells.Fixed(10)) {
        items(listItems.size) { index ->
            Text(
                text = "Item ${listItems[index]}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Yellow)
                    .size(100.dp)
            )
        }
    }
}

@Composable
fun LazyVerticalGridExample(modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(3)) {
        items(listItems.size) { index ->
            Text(
                text = "Item ${listItems[index]}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Yellow)
                    .size(100.dp)
            )
        }
    }

}

@Composable
fun LazyRowExample(modifier: Modifier = Modifier) {
    LazyRow {
        items(listItems.size) { index ->
            Text(
                text = "Item ${listItems[index]}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Yellow)
                    .size(100.dp)
            )
        }
    }
}


@Composable
fun LazyColumnExample(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        item {
            Text(
                text = "Single Item",
                fontWeight = FontWeight.Bold
            )
        }
        items(listItems.size) { index ->
            Text(
                text = "Item ${listItems[index]}",
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Yellow)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun ImageExample(modifier: Modifier = Modifier) {
    Image(
        modifier = Modifier.size(200.dp),
        contentScale = ContentScale.Crop,
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = null
    )
}

@Composable
fun TextFieldExample(modifier: Modifier = Modifier) {
    var textFieldValue by remember {
        mutableStateOf("")
    }

    TextField(
        value = textFieldValue,
        onValueChange = { newValue ->
            textFieldValue = newValue
        },
        placeholder = {
            Text(text = "Please subscribe to dev atrii")
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null
            )
        }
    )
}

@Composable
fun BoxExample(modifier: Modifier = Modifier) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .align(Alignment.TopCenter)
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Yellow)
        )

    }
}

@Composable
fun RowExample(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Yellow),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .padding(12.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
fun ColumnExample(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(10) {
            Box(
                modifier = Modifier
                    .width(150.dp)
                    .height(30.dp)
                    .padding(12.dp)
                    .background(Color.Red)
            )
        }
    }
}



















