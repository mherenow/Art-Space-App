package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentImage by remember { mutableIntStateOf(1) }

    when (currentImage) {
        1 -> {
            ArtSpace(
                imgResource = R.drawable.self_portrait_with_straw_hat,
                titleResource = R.string.self_portrait_with_straw_hat,
                artistResource = R.string.self_portrait_with_straw_hat_artist,
                yearResource = R.string.self_portrait_with_straw_hat_year,
                onNextClick = { currentImage = 2 },
                onPreviousClick = { currentImage = 10 }
            )
        }
        2 -> {
            ArtSpace(
                imgResource = R.drawable.whistlers_mother,
                titleResource = R.string.whistlers_mother,
                artistResource = R.string.whistlers_mother_artist,
                yearResource = R.string.whistlers_mother_year,
                onNextClick = { currentImage = 3 },
                onPreviousClick = { currentImage = 1 }
            )
        }
        3 -> {
            ArtSpace(
                imgResource = R.drawable.ivan_the_terrible_and_his_son_ivan,
                titleResource = R.string.ivan_the_terrible,
                artistResource = R.string.ivan_the_terrible_artist,
                yearResource = R.string.ivan_the_terrible_year,
                onNextClick = { currentImage = 4 },
                onPreviousClick = { currentImage = 2 }
            )
        }
        4 -> {
            ArtSpace(
                imgResource = R.drawable.las_meninas,
                titleResource = R.string.las_meninas,
                artistResource = R.string.las_meninas_artist,
                yearResource = R.string.las_meninas_year,
                onNextClick = { currentImage = 5 },
                onPreviousClick = { currentImage = 3 }
            )
        }
        5 -> {
            ArtSpace(
                imgResource = R.drawable.school_of_athens,
                titleResource = R.string.school_of_athens,
                artistResource = R.string.school_of_athens_artist,
                yearResource = R.string.school_of_athens_year,
                onNextClick = { currentImage = 6 },
                onPreviousClick = { currentImage = 4 }
            )
        }
        6 -> {
            ArtSpace(
                imgResource = R.drawable.nightwatch,
                titleResource = R.string.night_watch,
                artistResource = R.string.night_watch_artist,
                yearResource = R.string.night_watch_year,
                onNextClick = { currentImage = 7 },
                onPreviousClick = { currentImage = 5 }
            )
        }
        7 -> {
            ArtSpace(
                imgResource = R.drawable.hans_holbein,
                titleResource = R.string.hans_holbein,
                artistResource = R.string.hans_holbein_artist,
                yearResource = R.string.hans_holbein_year,
                onNextClick = { currentImage = 8 },
                onPreviousClick = { currentImage = 6 }
            )
        }
        8 -> {
            ArtSpace(
                imgResource = R.drawable.the_milkmaid,
                titleResource = R.string.the_milkmaid,
                artistResource = R.string.the_milkmaid_artist,
                yearResource = R.string.the_milkmaid_year,
                onNextClick = { currentImage = 9 },
                onPreviousClick = { currentImage = 7 }
            )
        }
        9 -> {
            ArtSpace(
                imgResource = R.drawable.englishman_at_moulin_rouge,
                titleResource = R.string.englishman_at_moulin_rougue,
                artistResource = R.string.englishman_at_moulin_rougue_artist,
                yearResource = R.string.englishman_at_moulin_rougue_year,
                onNextClick = { currentImage = 10 },
                onPreviousClick = { currentImage = 8 }
            )
        }
        10 -> {
            ArtSpace(
                imgResource = R.drawable.american_gothic,
                titleResource = R.string.american_gothic,
                artistResource = R.string.american_gothic_artist,
                yearResource = R.string.american_gothic_year,
                onNextClick = { currentImage = 1 },
                onPreviousClick = { currentImage = 9 }
            )
        }
    }
}

@Composable
fun ArtSpace(
    modifier: Modifier = Modifier,
    imgResource: Int,
    titleResource: Int,
    artistResource: Int,
    yearResource: Int,
    onNextClick: () -> Unit,
    onPreviousClick: () -> Unit
) {
    LazyColumn(modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround) {
        item {
            Surface(
                modifier = Modifier
                    .shadow(8.dp)
                    .border(2.dp, Color.Gray)
            ) {
                Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.Center) {
                    Image(
                        painter = painterResource(imgResource),
                        contentDescription = "${stringResource(titleResource)} by ${stringResource(artistResource)}",
                        modifier = Modifier
                            .padding(32.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
        item {
            Surface(
                modifier = Modifier.shadow(8.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(titleResource),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Light
                    )
                    Row {
                        Text(
                            text = stringResource(artistResource),
                            fontWeight = FontWeight.Light,
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "(${stringResource(yearResource)})",
                            fontWeight = FontWeight.Bold,
                        )
                    }
                }
            }
        }
        item {
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                Button(
                    modifier = Modifier.width(140.dp),
                    onClick = { onPreviousClick() }
                ) {
                    Text(text = "Previous")
                }
                Button(
                    modifier = Modifier.width(140.dp),
                    onClick = { onNextClick() }
                ) {
                    Text(text = "Next")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}