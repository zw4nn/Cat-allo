package fr.catallo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Pink = Color(0xFFFF4FA3)
private val Dark = Color(0xFF0B0E13)
private val Card = Color(0xFF151923)
private val Soft = Color(0xFF202532)
private val TextSoft = Color(0xFFB7BDC8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CATAlloApp() }
    }
}

@Composable
fun CATAlloApp() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            primary = Pink,
            background = Dark,
            surface = Card
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Dark
        ) {
            HomeScreen()
        }
    }
}

@Composable
private fun HomeScreen() {
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark)
            .padding(horizontal = 18.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    "CAT’Allo",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )
                Text(
                    "Catalogue • Matériel • Chantiers",
                    fontSize = 13.sp,
                    color = TextSoft
                )
            }

            Surface(
                color = Pink.copy(alpha = .14f),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text(
                    "v0.1.0",
                    color = Pink,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.catallo_logo),
            contentDescription = "Logo CAT’Allo",
            modifier = Modifier
                .fillMaxWidth()
                .height(165.dp)
                .clip(RoundedCornerShape(26.dp)),
            contentScale = ContentScale.Crop
        )

        Text(
            "Que cherches-tu ?",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            label = { Text("Rechercher du matériel") },
            placeholder = { Text("BP Plexo, ventouse, relais, câble…") },
            shape = RoundedCornerShape(18.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Pink,
                focusedLabelColor = Pink
            )
        )

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            DashboardCard(
                emoji = "📦",
                title = "Mon matériel",
                subtitle = "Catalogue, références et stock",
                modifier = Modifier.weight(1f)
            )
            DashboardCard(
                emoji = "🏗️",
                title = "Mes chantiers",
                subtitle = "Matériel utilisé par site",
                modifier = Modifier.weight(1f)
            )
        }

        DashboardCard(
            emoji = "📝",
            title = "Compte rendu",
            subtitle = "Préparer et retrouver les comptes rendus chantier",
            modifier = Modifier.fillMaxWidth()
        )

        Surface(
            modifier = Modifier.fillMaxWidth(),
            color = Soft,
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(modifier = Modifier.padding(18.dp)) {
                Text(
                    "Accès rapide",
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.White
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Ajoute rapidement un matériel, ouvre un chantier ou retrouve une référence.",
                    color = TextSoft,
                    fontSize = 13.sp
                )
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ajouter du matériel")
                }
            }
        }

        Spacer(Modifier.weight(1f))

        Text(
            "CAT’Allo • v0.1.0",
            color = Color.Gray,
            fontSize = 12.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
private fun DashboardCard(
    emoji: String,
    title: String,
    subtitle: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Card),
        shape = RoundedCornerShape(22.dp)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(emoji, fontSize = 28.sp)
            Text(
                title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                subtitle,
                color = TextSoft,
                fontSize = 12.sp
            )
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(14.dp)
            ) {
                Text("Ouvrir")
            }
        }
    }
}
