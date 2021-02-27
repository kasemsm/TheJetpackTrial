package com.example.androiddevchallenge.presentation.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.MyCats
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.SAMP
import com.example.androiddevchallenge.utils.loadPicture
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlin.random.Random.Default.nextFloat

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
class AdoptionsList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                ComposeNavigation()
            }
        }
    }
}

@ExperimentalFoundationApi
@ExperimentalCoroutinesApi
@Composable
fun LazyCatColumn(
    listItems: List<MyCats>,
    navController: NavController
) {
    Row {
        LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
            itemsIndexed(
                items = listItems
            ) { _, item ->
                CatCard(cats = item, onClick = {
                    navController.navigate("detail_screen/${item.catName}/${item.catBreedDetails}/${item.catImage}")
                })
            }
        })
    }
}


@ExperimentalCoroutinesApi
@Composable
fun CatCard(
    cats: MyCats,
    onClick: () -> Unit,
) {
    Card(
        shape = CutCornerShape(
            topStart = 10.dp,
            topEnd = 10.dp,
            bottomStart = 10.dp,
            bottomEnd = 10.dp
        ),
        modifier = Modifier
            .padding(14.dp)
            .fillMaxWidth()
            .clickable(onClick = onClick),
        elevation = 1.5.dp
    ) {
        Column {
            val image =
                cats.catImage?.let { loadPicture(url = it, defaultImage = SAMP).value }
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Cat Image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop,
                )
            }
            Column(modifier = Modifier.padding(top = 12.dp, start = 10.dp, bottom = 16.dp)) {
                Text(
                    fontSize = 15.sp,
                    fontFamily = FontFamily(Font(R.font.regular)),
                    text = cats.catName.toString(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                )
                Spacer(modifier = Modifier.padding(3.dp))
                Text(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.medium)),
                    text = "${cats.catBreed} Breed",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                )
                Spacer(modifier = Modifier.padding(1.dp))
                Text(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.light)),
                    text = "${cats.catSize}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.Start)
                )
            }
        }
    }
}

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun MainContent(navController: NavController) {
    val cats = mutableListOf<MyCats>()
    //1
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/maltese-portrait.jpg?la=en&hash=D9E453DCD438E1631C1D994426DAC62B064011BF",
            "Chip",
            "Maltese",
            "Male",
            "Medium Size",
            "With its soft and silky white coat, the Maltese is most likely one of the first breeds that comes to mind when thinking of small dogs."
        )
    )

    //2
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/dachshund-portrait.jpg?la=en&hash=CE8DD83BA8E34640681926C0F6314E4AB881C460",
            "Minnie",
            "Dachshund",
            "Female",
            "Small Size",
            "The Dachshund is an unmistakable breed that comes in miniature and standard sizes and a multitude of colors. They are extremely good looking and amusing dogs."
        )
    )

    //3
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/shih-tzu-portrait.jpg?la=en&hash=939ACC46D89D572D6342E831FC00EB4042CC2F9E",
            "Mack",
            "Shih Tzu",
            "Male",
            "Medium Size",
            "The Beagle should look like a miniature Foxhound, and is solid for the size. The Beagle’s moderate size enables the ability to follow on foot. Beagles can also be carried, and they can scurry around in thick underbrush."
        )
    )

    //4
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/pug-portrait.jpg?la=en&hash=D1BFE3128FFB000702F3B5191E6BB63F29D07A25",
            "Charley",
            "Pug",
            "Male",
            "Large Size",
            "The Pug is one of the most recognized dogs in the world, with its wrinkled brows, glimmering eyes, and curly tail. "
        )
    )


    //5
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/pomeranian-portrait.jpg?la=en&hash=7BE61068D85920B9DB49491F4D80EDEACACD08A5",
            "Pomeranian",
            "Treeing Walker",
            "Female",
            "Small Size",
            "The Pomeranian is a classic small dog that sports a fluffy coat, fox-like appearance, and eager grin.  Be sure to have plenty of dog play toys handy, because this breed thrives with regular exercise! They enjoy walking, running, playing, and sticking near their pet parents’ sides."
        )
    )

    //6
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/bichon-frise-portrait.jpg?la=en&hash=C749B302E87C26863BF206CDE7EBB5A5A93B73BD",
            "Oso",
            "Bichon Frise",
            "Male",
            "Small Size",
            "The Bichon Frise has a white, fluffy coat and endearing smile that wins over hearts. This breed is friendly, affectionate, and cheerful. The Bichon loves to entertain their family and spend as much quality time as they can with their pet parents."
        )
    )

    //7
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/toy-poodle-portrait.jpg?la=en&hash=D8DE931E48B40962EBC085D5A5120D71BD9E938F",
            "Peeper",
            "Poodle",
            "Female",
            "Small Size",
            "While the Poodle is often associated with dog shows, these curly-coated, muscular dogs are also great companions to welcome into your home. However, they are not exclusively in the small dog breed category; the small versions of this breed include Toy and Miniature Poodles. "
        )
    )

    //8
    cats.add(
        MyCats(
            "https://www.nylabone.com/-/media/Images/Nylabone-NA/US/Dog101/Activities-Fun/10-great-small-dog-breeds/chihuahua-portrait.jpg?la=en&hash=39B5D61E9664FF3768EB3B82941DAD5B9D446935",
            "Cleo",
            "Chihuahua",
            "Female",
            "Medium Size",
            "The Chihuahua is known for its tiny size but large personality—not to mention pointy ears and cute round eyes. Chihuahuas are extremely loyal, and their pet parents are, too! In fact, people who have a Chihuahua often have more than one in their lifetime."
        )
    )


    Column(
        modifier = Modifier.padding(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        LazyCatColumn(listItems = cats, navController = navController)
    }
}

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun ComposeNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable(
            "main_screen"
        ) {
            ListScreen(navController = navController)
        }
        composable(
            "detail_screen/{catName}/{catInfo}/{catUrl}",
            arguments = listOf(
                navArgument("catName")
                { type = NavType.StringType },

                navArgument("catInfo")
                { type = NavType.StringType },

                navArgument("catUrl")
                { type = NavType.StringType }),

            ) {
            DetailScreen(
                navController,
                catName = it.arguments?.getString("catName").toString(),
                catInfo = it.arguments?.getString("catInfo").toString(),
                catImage = it.arguments?.getString("catUrl").toString(),
            )
        }
    }
}

@ExperimentalCoroutinesApi
@ExperimentalFoundationApi
@Composable
fun ListScreen(navController: NavController) {
    // theme for our app.
    Scaffold(
        // below line we are
        // creating a top bar.
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "My Puppy",
                        color = Color.Black
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.my_puppy_icon),
                        contentDescription = "My App",
                        modifier = Modifier.padding(start = 20.dp)
                    )
                },
                backgroundColor = colorResource(id = R.color.purple_700)
            )
        }, content = {
            MainContent(navController = navController)
        })
}


@ExperimentalCoroutinesApi
@Composable
fun DetailScreen(
    navController: NavController,
    catName: String,
    catInfo: String,
    catImage: String
) {
    // theme for our app.
    Scaffold(
        // below line we are
        // creating a top bar.
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Say Hi to $catName",
                        color = Color.Black
                    )
                },

                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.Filled.ArrowBack, "Info",
                            tint = Color.Black
                        )
                    }
                },
                backgroundColor = colorResource(id = R.color.purple_700),
                contentColor = Color.White
            )
        }, content = {
            Column {
                Card(
                    shape = CutCornerShape(bottomEnd = 15.dp, bottomStart = 15.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {},
                    elevation = 1.5.dp
                ) {
                    Column {
                        val image =
                            catImage.let { url ->
                                loadPicture(
                                    url = url,
                                    defaultImage = SAMP
                                ).value
                            }

                        image?.let { img ->
                            Image(
                                bitmap = img.asImageBitmap(),
                                contentDescription = "Cat Image",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(240.dp),
                                contentScale = ContentScale.Crop,
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.padding(top = 15.dp))

                Card(
                    shape = CutCornerShape(8.dp),
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .clickable {},
                    elevation = 1.5.dp,
                ) {
                    Column(Modifier.padding(15.dp)) {
                        //Energy Level
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_energy),
                                contentDescription = "Energy Icon",
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.light)),
                                text = "Energy Level",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.Start)
                            )
                        }
                        Spacer(modifier = Modifier.padding(top = 10.dp))
                        LinearProgressIndicator(
                            modifier = Modifier.fillMaxWidth(),
                            progress = nextFloat()
                        )

                        //Playfulness
                        Spacer(modifier = Modifier.padding(top = 14.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_playfulness),
                                contentDescription = "Playfulness Icon",
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.light)),
                                text = "Playfulness",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.Start)
                            )
                        }
                        Spacer(modifier = Modifier.padding(top = 10.dp))
                        LinearProgressIndicator(
                            modifier = Modifier.fillMaxWidth(),
                            progress = nextFloat()
                        )

                        //Affection Level
                        Spacer(modifier = Modifier.padding(top = 14.dp))
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_afection),
                                contentDescription = "Affection Icon",
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            Text(
                                fontSize = 13.sp,
                                fontFamily = FontFamily(Font(R.font.light)),
                                text = "Affection Level",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentWidth(Alignment.Start)
                            )
                        }
                        Spacer(modifier = Modifier.padding(top = 10.dp))
                        LinearProgressIndicator(
                            modifier = Modifier.fillMaxWidth(),
                            progress = nextFloat()
                        )
                        Spacer(modifier = Modifier.padding(top = 20.dp))
                        Text(
                            fontSize = 15.sp,
                            fontFamily = FontFamily(Font(R.font.light)),
                            textAlign = TextAlign.Center,
                            text = catInfo,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(top = 15.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp, end = 20.dp),
                    onClick = {

                    },
                    shape = CutCornerShape(5.dp)
                ) {
                    Icon(
                        modifier = Modifier.padding(end = 10.dp),
                        painter = painterResource(id = R.drawable.adopt_pet),
                        contentDescription = "Adopt Icon"
                    )
                    Text(text = "Adopt this Cute Puppy?")
                }
            }
        })
}