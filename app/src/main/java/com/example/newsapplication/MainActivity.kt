package com.example.newsapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapplication.Feature_notes.presentation.add_edit_note.AddEditNoteScrean
import com.example.newsapplication.Feature_notes.presentation.notes.NotesScrean
import com.example.newsapplication.Feature_notes.presentation.util.Screan
import com.example.newsapplication.ui.theme.NewsApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController= rememberNavController()
                    NavHost(navController = navController, startDestination = Screan.NotesScrean.route ){
                        composable(route = Screan.NotesScrean.route){
                            NotesScrean(navController = navController)
                        }
                        composable(route = Screan.AddEditNoteScrean.route +
                                "?noteId={noteId}&noteColor={noteColor}", arguments = listOf(
                                    navArgument(
                                        name= "noteId"
                                    ){
                                        type= NavType.IntType
                                        defaultValue=-1
                                    },
                            navArgument(
                                name= "noteColor"
                            ){
                                type= NavType.IntType
                                defaultValue=-1
                            },


                            )
                        ){
                            val color=it.arguments?.getInt("noteColor") ?: -1
                            AddEditNoteScrean(navController = navController, noteColoe = color)



                        }


                    }
                }
            }
        }
    }
}

