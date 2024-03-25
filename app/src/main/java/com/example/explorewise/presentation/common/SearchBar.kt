package com.example.explorewise.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.isTraversalGroup
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.explorewise.R
import com.example.explorewise.ui.theme.ExploreWiseTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarSample() {

    var text by rememberSaveable { mutableStateOf("") }
    var active by rememberSaveable { mutableStateOf(false) }
    var searchHistory = remember { mutableStateListOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .semantics { isTraversalGroup = true }) {

        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .semantics { traversalIndex = -1f },
            query = text,
            onQueryChange = { text = it },
            active = active,
            onSearch = { active = false },
            onActiveChange = { active = it },
            colors = SearchBarDefaults.colors(colorResource(id = R.color.white)),
            trailingIcon = {
                Icon(
                    painter = painterResource(id = (R.drawable.ic_search)),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp),
                    tint = colorResource(id = R.color.textColor)
                )
            },
            placeholder = {
                Text(
                    text = "Search",
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(id = R.color.textColor)
                )
            }
        ){

            searchHistory.forEach {
                if (it.isNotEmpty()) {
                    Row(modifier = Modifier.padding(all = 14.dp)) {
                        Icon(imageVector = Icons.Default.History,
                            contentDescription = null)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(text = it)
                    }
                }
            }
            HorizontalDivider()
            Text(
                modifier = Modifier
                    .padding(all = 14.dp)
                    .fillMaxWidth()
                    .clickable {
                        searchHistory.clear()
                    },
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                text = "clear all history"
            )

        }

    }
}


@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    ExploreWiseTheme {
        SearchBarSample()
    }
}
