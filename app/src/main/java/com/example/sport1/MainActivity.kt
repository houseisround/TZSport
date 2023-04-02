package com.example.sport1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sport1.model.Sport
import com.example.sport1.ui.theme.Sport1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ListItem(item: Sport){

    var expanded by remember{ mutableStateOf(false) }

    Card(modifier = Modifier
        .fillMaxWidth()
        .background(color = Color.White)
        .padding(10.dp))
    {
        Box(modifier = Modifier.background(color= Color.White)){
            Column(modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )) {
                Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.background(color = Color.White)) {
                    Image(painter = painterResource(id = item.image),
                        contentDescription ="",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(5.dp)
                            .size(90.dp)
                            .clip(CircleShape))
                    Column(modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)) {
                        Text(stringResource(id = item.name), fontSize = 25.sp)
                    }
                    IconButton(onClick = { expanded = !expanded}) {
                        Icon(imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                            contentDescription = "" )
                    }
                }
                if (expanded) Text(stringResource(id = item.information), fontSize = 14.sp)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Nue(){
    LazyColumn(){
        itemsIndexed(listOf(
            Sport(R.string.football,R.drawable.football,R.string.football_inf),
            Sport(R.string.basketball,R.drawable.basketball,R.string.basketball_inf),
            Sport(R.string.volleyball,R.drawable.volleyball,R.string.volleyball_inf),
            Sport(R.string.football,R.drawable.football,R.string.football_inf),
            Sport(R.string.basketball,R.drawable.basketball,R.string.basketball_inf),
            Sport(R.string.volleyball,R.drawable.volleyball,R.string.volleyball_inf),
            Sport(R.string.football,R.drawable.football,R.string.football_inf),
            Sport(R.string.basketball,R.drawable.basketball,R.string.basketball_inf),
            Sport(R.string.volleyball,R.drawable.volleyball,R.string.volleyball_inf)
        )){
            _,item-> ListItem(item = item)
    }
    }
}