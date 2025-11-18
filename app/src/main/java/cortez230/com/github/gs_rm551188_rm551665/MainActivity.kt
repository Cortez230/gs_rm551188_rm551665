package cortez230.com.github.gs_rm551188_rm551665


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cortez230.com.github.gs_rm551188_rm551665.screens.EquipeScreen
import cortez230.com.github.gs_rm551188_rm551665.screens.IMCScreen
import cortez230.com.github.gs_rm551188_rm551665.screens.LoginScreen
import cortez230.com.github.gs_rm551188_rm551665.screens.MenuScreen
import cortez230.com.github.gs_rm551188_rm551665.ui.theme.Gsrm551188rm551665Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Gsrm551188rm551665Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                    ) {
                        composable(route = "login") {
                            LoginScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "menu") {
                            MenuScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "imc") {
                            IMCScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                        composable(route = "equipe") {
                            EquipeScreen(modifier = Modifier.padding(innerPadding), navController)
                        }
                    }
                }
            }
        }
    }
}